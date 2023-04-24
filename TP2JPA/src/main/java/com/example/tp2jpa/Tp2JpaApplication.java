package com.example.tp2jpa;

import com.example.tp2jpa.entities.Patient;
import com.example.tp2jpa.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class Tp2JpaApplication implements CommandLineRunner {
    @Autowired
    private PatientRepository patientRepository;
    public static void main(String[] args) {

        SpringApplication.run(Tp2JpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 100; i++) {
            patientRepository.save(new Patient(null, "Hassan" + i, new Date(), Math.random()>0.5?true:false, (int) (Math.random() * 1000)));
        }

        patientRepository.save(new Patient(null, "Hassan", new Date(), false, 56));
        patientRepository.save(new Patient(null, "Mohammed", new Date(), true, 100));
        patientRepository.save(new Patient(null, "Imane", new Date(), false, 210));
        Page<Patient> patients = patientRepository.findAll(PageRequest.of(1,5));
        System.out.println("Total Pages: " + patients.getTotalPages());
        System.out.println("Total Elements: " + patients.getTotalElements());
        System.out.println("Number of Elements: " + patients.getNumber());
        List<Patient> content = patients.getContent();
        Page<Patient> listdemalde =patientRepository.findByMaladeIs(true, PageRequest.of(0, 4));



        listdemalde.forEach(p -> {
            System.out.println("***************************");
            System.out.println(p.getId());
            System.out.println(p.getNom());
            System.out.println(p.getDateNaissance());
            System.out.println(p.getScore());
            System.out.println(p.isMalade());
        });
        System.out.println("***************************");
        Patient patient = patientRepository.findById(1L).orElse(null);
        if (patient != null) {
            System.out.println(patient.getNom());
            System.out.println(patient.isMalade());
        }
        patient.setScore(870);
        patientRepository.save(patient);
        patientRepository.deleteById(2L);
    }
}
