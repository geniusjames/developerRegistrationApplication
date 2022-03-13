package com.genius.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class DeveloperConfig {

    @Bean
    CommandLineRunner commandLineRunner(DeveloperRepository repository) {
        return args -> {
            Developer james = new Developer(

                    "James",
                    "iOS",
                    LocalDate.of(1992, 07,04),
                    "jameslecturer@yahoo.com"
            );

           Developer toba = new Developer(
                    "Toba",
                    "iOS",
                    LocalDate.of(1992, 07,04),
                    "geniusjames7@gmail.com"
            );
            repository.saveAll(
                    List.of(
                            james, toba
                    )
            );
        };
    }
}
