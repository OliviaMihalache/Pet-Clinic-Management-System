package com.sda.olivia.petclinic.service;

import com.sda.olivia.petclinic.model.Pet;

import java.util.List;

public interface ClientService {
    List<Pet> findPetsForClientId(Long clientId);
}
