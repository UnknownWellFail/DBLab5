package com.wellfail.dblab5.repository;

import com.wellfail.dblab5.entity.Developer;
import org.springframework.data.repository.CrudRepository;

public interface DeveloperRepository extends CrudRepository<Developer, Integer> {
}
