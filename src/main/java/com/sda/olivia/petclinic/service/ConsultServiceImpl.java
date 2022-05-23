package com.sda.olivia.petclinic.service;

import com.sda.olivia.petclinic.model.Consult;
import com.sda.olivia.petclinic.model.Pet;
import com.sda.olivia.petclinic.model.Veterinarian;
import com.sda.olivia.petclinic.repository.base.*;
import com.sda.olivia.petclinic.service.exception.InvalidParameterException;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class ConsultServiceImpl implements ConsultService {

    private final ConsultRepository consultRepository;
    private final PetRepository petRepository;
    private final VeterinarianRepository vetRepository;


    public ConsultServiceImpl() {
        this.consultRepository = new ConsultRepositoryImpl();
        this.petRepository = new PetRepositoryImpl();
        this.vetRepository = new VeterinarianRepositoryImpl();
    }

    @Override
    public void create(Date date, String description, Long vetId, Long petId) throws InvalidParameterException {
        if (date == null) {
            throw new InvalidParameterException("Date of consult is null.");
        }
        if (description == null || description.isBlank()) {
            throw new InvalidParameterException("Description is null or empty.");
        }

        if(vetId == null){
            throw new InvalidParameterException("Vet Id is null");
        }
        if(petId == null){
            throw new InvalidParameterException("Pet Id is null");
        }

        Optional<Pet> petFromDB = petRepository.findById(petId);
        Optional<Veterinarian> vetFromDB = vetRepository.findById(vetId);

        if (petFromDB.isEmpty()) {
            throw new InvalidParameterException("Invalid pet id. Please select an existing pet!");
        }
        if (vetFromDB.isEmpty()) {
            throw new InvalidParameterException("Invalid vet id. Please select an existing vet!");

        }

        Consult consult = new Consult(date, description);
        consult.setPet(petFromDB.get());
        consult.setVeterinarian(vetFromDB.get());
        consultRepository.create(consult);
    }

    @Override
    public List<Consult> findAllUnvaccinatedPets() {
        return consultRepository.findAllUnvaccinatedPets();
    }

    @Override
    public List<Consult> findAllByVetIdAndDateBetween(Long vetId, Date startDate, Date endDate) throws InvalidParameterException{
        if(vetId == null) {
            throw new InvalidParameterException("Invalid vet id");
        }
        if(startDate == null){
            throw new InvalidParameterException("Invalid  start date");
        }
        if (endDate == null) {
            throw new InvalidParameterException("Invalid end date");
        }
        return consultRepository.findAllByVetIdAndDateBetween(vetId, startDate,endDate);
    }
}