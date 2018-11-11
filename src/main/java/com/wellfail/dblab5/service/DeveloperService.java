package com.wellfail.dblab5.service;

import com.wellfail.dblab5.entity.*;
import com.wellfail.dblab5.repository.DeveloperRepository;
import com.wellfail.dblab5.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DeveloperService {


    @Autowired
    private DeveloperRepository developerRepository;

    @Autowired
    private ProfileRepository profileRepository;

    public List<Developer> findAll() {
        return (List<Developer>) developerRepository.findAll();
    }

    public void saveDeveloper(Developer developer, Map<String, String> form) {
        developer.getProfiles().clear();

        Map<String, Profile> profiles = new HashMap<>();
        for (Profile profile : profileRepository.findAll()) {
            profiles.put(profile.getName(), profile);
        }

        for (String key : form.keySet()) {
            if (profiles.containsKey(key)) {
                developer.getProfiles().add(profiles.get(key));
            }
        }
        developerRepository.save(developer);
    }

    public void removeDeveloper(Developer developer){
        developerRepository.delete(developer);
    }
}

