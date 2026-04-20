package com.edutech.progressive.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.edutech.progressive.dto.PatientDTO;
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
    public List<PatientDTO> getAllPatients() throws SQLException {
        List<Patient> list = patientRepository.findAll();
        if(list.isEmpty()){
            throw new PatientNotFoundException("Patient not found");
        }
        List<PatientDTO> patientDTOs = new ArrayList<>();
        for(Patient p : list){
            patientDTOs.add(convertToDto(p));
        }
        return patientDTOs;
    }

    @Override
    public Integer addPatient(PatientDTO patientDto) throws SQLException {
        Patient patient = convertToEntity(patientDto);
        Optional<Patient> p = patientRepository.findByEmail(patient.getEmail());
        if(p.isPresent()){
            throw new PatientAlreadyExistsException("Patient already exists with same email");
        }
        Patient pp = patientRepository.save(patient);
        return pp.getPatientId();
    }

    @Override
    public List<PatientDTO> getAllPatientSortedByName() throws SQLException {
        List<Patient> p = patientRepository.findAll();
        if(p.isEmpty()){
            throw new PatientNotFoundException("Patient not found");
        }
        Collections.sort(p);
        List<PatientDTO> patientDTOs = new ArrayList<>();
        for(Patient pp : p){
            patientDTOs.add(convertToDto(pp));
        }
        return patientDTOs;
    }

    public void updatePatient(PatientDTO patientDto) throws SQLException {
        Patient patient = convertToEntity(patientDto);
        patientRepository.save(patient);
    }

    public void deletePatient(int patientId) throws SQLException {
        Optional<Patient> p = patientRepository.findById(patientId);
        if(p.isPresent()){
            billingRepository.deleteByPatientId(patientId);
            patientRepository.deleteById(patientId);
        }
    }

    public PatientDTO getPatientById(int patientId) throws SQLException {
        Optional<Patient> p = patientRepository.findById(patientId);
        if(p.isPresent()){
            return convertToDto(patientRepository.findById(patientId).get());
        }
        throw new PatientNotFoundException("Patient not found");
    }

    public Patient convertToEntity(PatientDTO patientDTO){
        Patient patient = new Patient();
        patient.setPatientId(patientDTO.getPatientId());
        patient.setFullName(patientDTO.getFullName());
        patient.setEmail(patientDTO.getEmail());
        patient.setDateOfBirth(patientDTO.getDateOfBirth());
        patient.setContactNumber(patientDTO.getContactNumber());
        patient.setAddress(patientDTO.getAddress());
        return patient;
    }

    public PatientDTO convertToDto(Patient patient){
        PatientDTO dto = new PatientDTO();
        dto.setPatientId(patient.getPatientId());
        dto.setFullName(patient.getFullName());
        dto.setEmail(patient.getEmail());
        dto.setDateOfBirth(patient.getDateOfBirth());
        dto.setContactNumber(patient.getContactNumber());
        dto.setAddress(patient.getAddress());
        return dto;
    }
}