package com.edutech.progressive.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.edutech.progressive.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
    @Query("select p from Patient p where p.patientId=:pid")
    Patient findByPatientId(@Param("pid") Integer pid);
}
