package com.sda.olivia.petclinic.service;

import com.sda.olivia.petclinic.service.exception.InvalidParameterException;

import java.util.Date;
import java.util.InvalidPropertiesFormatException;

public interface PetService {
    void create(String race, Date birthDate, boolean isVaccinated, String ownerFirstName, String ownerLastName) throws InvalidPropertiesFormatException, InvalidParameterException;
}
