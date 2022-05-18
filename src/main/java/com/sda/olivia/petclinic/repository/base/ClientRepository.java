package com.sda.olivia.petclinic.repository.base;

import com.sda.olivia.petclinic.model.Client;

import java.util.Optional;

public interface ClientRepository extends BaseRepository<Client, Long>{
    Optional<Client> findByName(String firstName, String lastName);
}

