package com.sda.olivia.petclinic.service;

import com.sda.olivia.petclinic.model.Client;
import com.sda.olivia.petclinic.model.Pet;
import com.sda.olivia.petclinic.repository.base.ClientRepository;
import com.sda.olivia.petclinic.repository.base.ClientRepositoryImpl;
import com.sda.olivia.petclinic.repository.base.PetRepository;
import com.sda.olivia.petclinic.repository.base.PetRepositoryImpl;
import com.sda.olivia.petclinic.service.dto.PetDto;
import com.sda.olivia.petclinic.service.exception.InvalidParameterException;

import java.util.Date;
import java.util.InvalidPropertiesFormatException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PetServiceImpl implements PetService {

    private final PetRepository petRepository;
    private final ClientRepository clientRepository;

    public PetServiceImpl() {
        this.petRepository = new PetRepositoryImpl();
        this.clientRepository = new ClientRepositoryImpl();
    }


    @Override
    public void create(String race, Date birthDate, boolean isVaccinated, String ownerFirstName, String ownerLastName) throws InvalidPropertiesFormatException, InvalidParameterException {
        if (race.isEmpty() || race.isBlank()) {
            throw new InvalidParameterException("The race is null or blank");
        }
        if (birthDate == null) {
            throw new InvalidParameterException("The birthdate is null");
        }
        if (birthDate.after(new Date())) {
            throw new InvalidParameterException("The birthdate is in the future");
        }
        if (ownerFirstName == null || ownerFirstName.isBlank()) {
            throw new InvalidParameterException("The owner's first name is null or blank");
        }
        if (ownerLastName == null || ownerLastName.isBlank()) {
            throw new InvalidParameterException("The owner's last name is null or blank");
        }
        Optional<Client> clientResult = clientRepository.findByName(ownerFirstName, ownerLastName);
        if(clientResult.isEmpty()){
            Client client = new Client(ownerFirstName, ownerLastName,null, null);
            clientRepository.create(client);
            clientResult=Optional.of(client);
        }
        Pet pet = new Pet(race, birthDate, isVaccinated);
        pet.setOwner(clientResult.get());
        petRepository.create(pet);
    }

    @Override
    public List<Pet> findAllVaccinated() {
        return petRepository.findAllVaccinated();
    }
    public List<PetDto> findAll(){
        return petRepository
                .findAll().stream()
                .map(pet -> new PetDto(pet.getId(),
                pet.getRace(),
                pet.getDateOfBirth(),
                pet.getVaccinated())).collect(Collectors.toList());

    }
    public void deletePetsById(Long id){
        petRepository.deleteById(id);
    }
}


