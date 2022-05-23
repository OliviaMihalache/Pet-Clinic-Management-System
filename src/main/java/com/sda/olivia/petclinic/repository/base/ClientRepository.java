package com.sda.olivia.petclinic.repository.base;

import com.sda.olivia.petclinic.model.Client;
import com.sda.olivia.petclinic.utils.SessionManager;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public interface ClientRepository extends BaseRepository<Client, Long>{
    Optional<Client> findByName(String firstName, String lastName);

    Optional<Client> findByIdAndLoadPets(Long id);

}

