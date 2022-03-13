package com.genius.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Transient;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "api/genius/developer")
public class DeveloperController {
    private final DeveloperService service;

    @Autowired
    public DeveloperController(DeveloperService developerService) {
        this.service = developerService;
    }

    @GetMapping
    public List<Developer> displayDev() {
        return service.displayDev();
    }

    @PostMapping
    public void addNewDeveloper(@RequestBody Developer developer) { service.addNewDeveloper(developer);
    }

    @DeleteMapping(path = "{developerId}")
    public void deleteDeveloper(@PathVariable("developerId") Long developerId) {
        service.deleteDeveloper(developerId);
    }

    @Transactional
    @PutMapping(path = "{developerId}")
    public void updateDeveloper(@PathVariable("developerId") Long developerId,
                                @RequestParam String newName,
                                @RequestParam String newEmail) {
        service.updateDeveloper(developerId, newName, newEmail);
    }


}
