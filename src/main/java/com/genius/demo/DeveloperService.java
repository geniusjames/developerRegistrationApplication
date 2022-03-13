package com.genius.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DeveloperService {
    DeveloperRepository developerRepository;

    @Autowired
    public DeveloperService(DeveloperRepository developerRepository) {
        this.developerRepository = developerRepository;
    }

    public List<Developer> displayDev() {
        return developerRepository.findAll();
    }

    public void addNewDeveloper(Developer developer) {

            Optional<Developer> developerEmail = developerRepository.findByEmail(developer.getEmail());
            if (developerEmail.isPresent()) {
                throw new IllegalStateException("Email taken");
            }
            System.out.println(developer);
            developerRepository.save(developer);
    }

    public void deleteDeveloper(Long developerId) {
        boolean exists = developerRepository.existsById(developerId);
        if(!exists){
            throw new IllegalStateException("developer with " + developerId + " not found");
        }
        developerRepository.deleteById(developerId);
    }

    public void updateDeveloper(Long developerId, String newName, String newEmail) {
        boolean exists = developerRepository.existsById(developerId);
        if(!exists) {
            throw new IllegalStateException("no developer of id " + " exists");
        }
        Optional<Developer> optionalDeveloper = developerRepository.findById(developerId);
        optionalDeveloper.ifPresent(developer -> {
            developer.setEmail(newEmail);
            developer.setName(newName);
        });
    }
}
