package com.wellfail.dblab5.service;

import com.wellfail.dblab5.entity.Client;
import com.wellfail.dblab5.entity.Developer;
import com.wellfail.dblab5.entity.Profile;
import com.wellfail.dblab5.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> findAll() {
        return (List<Client>) clientRepository.findAll();
    }

    public void saveClient(Client client, Map<String, String> form) {
/*
        Map<String, Profile> profiles = new HashMap<>();
        for (Profile profile : profileRepository.findAll()) {
            profiles.put(profile.getName(), profile);
        }

        for (String key : form.keySet()) {
            if (profiles.containsKey(key)) {
                developer.getProfiles().add(profiles.get(key));
            }
        }*/
        clientRepository.save(client);
    }

    public void removeProfile(Client client) {
        clientRepository.delete(client);
    }
}
