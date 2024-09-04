package org.ks.photoapp.domain.client;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {

    Optional<Client> findByLastName(String lastName);
    void deleteClientById(Long id);

    }

