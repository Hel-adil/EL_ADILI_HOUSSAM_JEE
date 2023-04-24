package com.example.tp2jpa.repositories;

import com.example.tp2jpa.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findByMaladeIs(boolean m);
    Page<Patient> findByMaladeIs(boolean m, Pageable pageable);
    List<Patient> findByMaladeIsAndScoreLessThan(boolean m, int score);
    List<Patient> findByMaladeIsTrueAndScoreLessThan(int score);
    List<Patient> findByDateNaissanceBetweenAndMaladeIsTrueOrNomLike(Date d1, Date d2 , String mc);

   /* @Query("select p from Patient p where p.dateNaissance between :x and :y  and p.nom like :z ")
    List<Patient> chercherPatients(@Param("x") Date d1, @Param("y")Date d2 , @Param("z")String mc, boolean m, int nom);*/


}
