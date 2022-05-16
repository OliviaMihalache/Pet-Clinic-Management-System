package com.sda.olivia.petclinic.service;

import com.sda.olivia.petclinic.service.exception.InvalidParameterException;

public interface VeterinarianService {

    void create(String firstName, String lastName, String address, String speciality) throws InvalidParameterException;


}
