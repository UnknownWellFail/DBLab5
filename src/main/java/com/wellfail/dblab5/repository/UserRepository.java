package com.wellfail.dblab5.repository;


import com.wellfail.dblab5.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);

    User findByActivationCode(String code);
}
