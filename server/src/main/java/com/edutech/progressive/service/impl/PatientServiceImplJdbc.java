// package com.edutech.progressive.service.impl;

// import java.sql.SQLException;
// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.List;

// import com.edutech.progressive.dao.PatientDAO;
// import com.edutech.progressive.entity.Patient;
// import com.edutech.progressive.service.PatientService;

// public class PatientServiceImplJdbc implements PatientService {

//     private PatientDAO patientDAO;

//     public PatientServiceImplJdbc(PatientDAO patientDAO) {
//         this.patientDAO = patientDAO;
//     }

//     @Override
//     public List<Patient> getAllPatients() throws SQLException {
//         return patientDAO.getAllPatients();
//     }

//     @Override
//     public Integer addPatient(Patient patient) throws SQLException {
//         return patientDAO.addPatient(patient);
//     }

//     @Override
//     public void updatePatient(Patient patient) throws SQLException {
//         patientDAO.updatePatient(patient);
//     }

//     @Override
//     public void deletePatient(int patientId) throws SQLException {
//         patientDAO.deletePatient(patientId);
//     }

//     @Override
//     public List<Patient> getAllPatientSortedByName() throws SQLException {
//         List<Patient> patients = new ArrayList<>(patientDAO.getAllPatients());
//         Collections.sort(patients);
//         return patients;
//     }

//     @Override
//     public Patient getPatientById(int patientId) throws SQLException {
//         return patientDAO.getPatientById(patientId);
//     }
// }