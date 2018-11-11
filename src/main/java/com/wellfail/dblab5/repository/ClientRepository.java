package com.wellfail.dblab5.repository;

import com.wellfail.dblab5.entity.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client,Integer> {
    Client findByEmail(String email);
}
