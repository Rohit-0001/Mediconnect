package com.edutech.progressive.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.edutech.progressive.entity.Billing;

@Repository
public interface BillingRepository extends JpaRepository<Billing, Integer> {
    
    List<Billing> findByPatient_PatientId(int patientId);

    @Transactional
    @Modifying
    @Query("DELETE FROM Billing b WHERE b.patient.patientId = :patientId")
    void deleteByPatientId(int patientId);

}
