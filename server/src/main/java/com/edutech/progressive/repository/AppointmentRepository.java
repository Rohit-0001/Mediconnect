package com.edutech.progressive.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.edutech.progressive.entity.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer>{
    
    public List<Appointment> findByClinic_ClinicId(int clinicId);

    public List<Appointment> findByPatient_PatientId(int patientId);

    public List<Appointment> findByStatus(String status);

    @Transactional
    @Modifying
    @Query("DELETE FROM Appointment a WHERE a.patient.patientId = :patientId")
    void deleteByPatientId(@Param("patientId") int patientId);

    @Transactional
    @Modifying
    @Query("DELETE FROM Appointment a WHERE a.clinic.clinicId = :clinicId")
    void deleteByClinicId(@Param("clinicId") int clinicId);

    @Query("DELETE FROM Appointment a WHERE a.patient.patientId IN (SELECT p.patientId FROM Patient p WHERE p.doctor.doctorId = :doctorId)")
    void deleteByDoctorId(int doctorId);


}
