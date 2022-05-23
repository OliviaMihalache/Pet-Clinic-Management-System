package com.sda.olivia.petclinic.repository.base;

import com.sda.olivia.petclinic.model.Consult;

import java.util.List;

public interface ConsultRepository extends BaseRepository<Consult, Long> {
    List<Consult> findAllUnvaccinatedPets();
}