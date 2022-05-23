package com.sda.olivia.petclinic.service;

import com.sda.olivia.petclinic.model.Consult;
import com.sda.olivia.petclinic.service.exception.InvalidParameterException;


import java.util.Date;
import java.util.List;



public interface ConsultService {

    void create(Date date, String description, Long vetId, Long PetId) throws InvalidParameterException;
    List<Consult> findAllUnvaccinatedPets();

}