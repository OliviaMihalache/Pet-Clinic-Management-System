package com.sda.olivia.petclinic.service;

import com.sda.olivia.petclinic.model.Veterinarian;
import com.sda.olivia.petclinic.repository.base.VeterinarianRepository;
import com.sda.olivia.petclinic.repository.base.VeterinarianRepositoryImpl;
import com.sda.olivia.petclinic.service.exception.InvalidParameterException;

public class VeterinarianServiceImpl implements VeterinarianService{
   private final VeterinarianRepository veterinarianRepository;

    public VeterinarianServiceImpl(){
        this.veterinarianRepository = new VeterinarianRepositoryImpl();
    }

    @Override
    public void create (String firstName, String lastName, String address, String speciality) throws InvalidParameterException {
        if(firstName== null || firstName.isBlank()){
            throw new InvalidParameterException("First name is null or empty");
        }
        if(lastName== null || lastName.isBlank()){
            throw new InvalidParameterException("Last name is null or empty");
        }
        if(address== null || address.isBlank()){
            throw new InvalidParameterException("Address is null or empty");
        }
        if(speciality== null || speciality.isBlank()){
            throw new InvalidParameterException("Speciality is null or empty");
        }

        veterinarianRepository.create(new Veterinarian(firstName, lastName, address, speciality));
    }
}
