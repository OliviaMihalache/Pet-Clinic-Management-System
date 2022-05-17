package com.sda.olivia.petclinic.service;

import com.sda.olivia.petclinic.service.dto.VeterinarianDto;
import com.sda.olivia.petclinic.service.exception.InvalidParameterException;

import java.util.List;

public interface VeterinarianService {

    void create(String firstName, String lastName, String address, String speciality) throws InvalidParameterException;

    List<VeterinarianDto> findAll();

    void deleteById(Long id);
    void update(String firstName, String lastName,
                String address, String speciality)
            throws InvalidParameterException;


    void update(Long id, String firstName, String lastName, String address, String speciality) throws InvalidParameterException;
}
