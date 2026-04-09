package com.edutech.progressive.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.edutech.progressive.entity.Patient;
import com.edutech.progressive.service.PatientService;

public class PatientServiceImplArraylist implements PatientService {

    @Override
    public List<Patient> getAllPatients() {
        return new ArrayList<>();
    }

    @Override
    public Integer addPatient(Patient patient) {
        return -1;
    }

    @Override
    public List<Patient> getAllPatientSortedByName() {
        return new ArrayList<>();
    }
    @Override
    public void emptyArrayList(){

    }

}