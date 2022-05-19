package com.sda.olivia.petclinic.repository.base;

import com.sda.olivia.petclinic.model.Pet;

import java.util.List;

public interface PetRepository extends BaseRepository<Pet,Long>{
    List<Pet>findAllVaccinated();
}
