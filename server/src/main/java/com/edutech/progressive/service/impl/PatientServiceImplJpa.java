package com.edutech.progressive.service.impl;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.edutech.progressive.entity.Patient;
import com.edutech.progressive.exception.PatientAlreadyExistsException;
import com.edutech.progressive.exception.PatientNotFoundException;
import com.edutech.progressive.repository.BillingRepository;
import com.edutech.progressive.repository.PatientRepository;
import com.edutech.progressive.service.PatientService;

@Service
@Primary
public class PatientServiceImplJpa implements PatientService {

    PatientRepository patientRepository;
    
    @Autowired
    private BillingRepository billingRepository;

    public PatientServiceImplJpa(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public List<Patient> getAllPatients() throws SQLException {
        return patientRepository.findAll();
    }

    @Override
    public Integer addPatient(Patient patient) throws SQLException {
        if(patientRepository.findByEmail(patient.getEmail()).isPresent()){
            throw new PatientAlreadyExistsException("Patient already exists");
        }
        Patient p = patientRepository.save(patient);
        return p.getPatientId();
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
            billingRepository.deleteByPatientId(patientId);
            patientRepository.deleteById(patientId);
        }
    }

    public Patient getPatientById(int patientId) throws SQLException {
        Optional<Patient> p = patientRepository.findById(patientId);
        if(p.isPresent()){
            billingRepository.deleteByPatientId(patientId);
            return patientRepository.findById(patientId).get();
        }
        throw new PatientNotFoundException("Patient not found");
    }
}