package com.wellfail.dblab5.service;

import com.wellfail.dblab5.entity.Profile;
import com.wellfail.dblab5.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {


    @Autowired
    private ProfileRepository profileRepository;

    public List<Profile> findAll() {
        return (List<Profile>) profileRepository.findAll();
    }

    public void addProfile(Profile profile){
        profileRepository.save(profile);
    }

    public void removeProfile(Profile profile){
        profileRepository.delete(profile);
    }
}
