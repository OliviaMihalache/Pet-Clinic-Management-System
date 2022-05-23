package com.sda.olivia.petclinic.service;

import com.sda.olivia.petclinic.model.Client;
import com.sda.olivia.petclinic.model.Pet;
import com.sda.olivia.petclinic.repository.base.ClientRepository;
import com.sda.olivia.petclinic.repository.base.ClientRepositoryImpl;

import javax.management.openmbean.OpenDataException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository ;

    public ClientServiceImpl() {
        this.clientRepository = new ClientRepositoryImpl();

    }


    @Override
    public List<Pet> findPetsForClientId(Long clientId) {
        return null;
    }
}
