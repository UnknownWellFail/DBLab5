package com.wellfail.dblab5.repository;

import com.wellfail.dblab5.entity.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile,Integer> {
}
