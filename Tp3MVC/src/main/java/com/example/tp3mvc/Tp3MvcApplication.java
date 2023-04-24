package com.example.tp3mvc;

import com.example.tp3mvc.entities.Patient;
import com.example.tp3mvc.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class Tp3MvcApplication {

    public static void main(String[] args) {

        SpringApplication.run(Tp3MvcApplication.class, args);
    }
    //@Bean
    CommandLineRunner commandLineRunner (PatientRepository patientRepository){
        return args -> {
            patientRepository.save(new Patient(null, "Hassan", new Date(), false, 845));
            patientRepository.save(new Patient(null, "Mohammed", new Date(), true, 160));
            patientRepository.save(new Patient(null, "Yassmine", new Date(), true, 210));
            patientRepository.save(new Patient(null, "Houssam", new Date(), false, 547));
            patientRepository.findAll().forEach(p -> {
                System.out.println(p.getNom());
            });
        };
    }
}
