package com.edutech.progressive.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.edutech.progressive.entity.Patient;
import com.edutech.progressive.service.PatientService;

public class PatientServiceImplJdbc implements PatientService {

    @Override
    public List<Patient> getAllPatients() {
        return new ArrayList<>();
    }

    @Override
    public Integer addPatient(Patient patient) {
        return -1;
    }

    @Override
    public void updatePatient(Patient patient){

    }

    @Override
    public void deletePatient(int patientId){

    }

    @Override
    public List<Patient> getAllPatientSortedByName() {
        return new ArrayList<>();
    }

    public Patient getPatientById(int patientId) {
        return null;
    }
}