package com.sda.olivia.petclinic.repository.base;

import com.sda.olivia.petclinic.model.Pet;

public class PetRepositoryImpl extends BaseRepositoryImpl<Pet, Long> implements PetRepository {
    public PetRepositoryImpl() {
        super(Pet.class);
    }
}
