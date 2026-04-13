package com.edutech.progressive.service.impl;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.edutech.progressive.entity.Patient;
import com.edutech.progressive.repository.PatientRepository;
import com.edutech.progressive.service.PatientService;

@Service
@Primary
public class PatientServiceImplJpa implements PatientService {

    PatientRepository patientRepository;
    
    public PatientServiceImplJpa(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public List<Patient> getAllPatients() throws SQLException {
        return patientRepository.findAll();
    }

    @Override
    public Integer addPatient(Patient patient) throws SQLException {
        patientRepository.save(patient);
        return 1;
    }

    @Override
    public List<Patient> getAllPatientSortedByName() throws SQLException {
        List<Patient> p = patientRepository.findAll();
        Collections.sort(p);
        return p;
    }

    public void updatePatient(Patient patient) throws SQLException {
        patientRepository.save(patient);
    }

    public void deletePatient(int patientId) throws SQLException {
        Optional<Patient> p = patientRepository.findById(patientId);
        if(p.isPresent()){
            patientRepository.deleteById(patientId);
        }
    }

    public Patient getPatientById(int patientId) throws SQLException {
        Optional<Patient> p = patientRepository.findById(patientId);
        if(p.isPresent()){
            return patientRepository.findById(patientId).get();
        }
        return null;
    }
}