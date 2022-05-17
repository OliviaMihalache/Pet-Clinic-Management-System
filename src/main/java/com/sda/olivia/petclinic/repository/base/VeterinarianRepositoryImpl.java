package com.sda.olivia.petclinic.repository.base;

import com.sda.olivia.petclinic.model.Veterinarian;

public class VeterinarianRepositoryImpl extends BaseRepositoryImpl<Veterinarian,Long>implements VeterinarianRepository {
    public VeterinarianRepositoryImpl(){
        super(Veterinarian.class);
    }
}
