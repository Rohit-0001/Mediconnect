package com.edutech.progressive.service;

import com.edutech.progressive.dto.PatientDTO;
import com.edutech.progressive.entity.Patient;

import java.sql.SQLException;
import java.util.List;

public interface PatientService {

    List<PatientDTO> getAllPatients() throws SQLException;

    Integer addPatient(PatientDTO patientDTO) throws SQLException;

    List<PatientDTO> getAllPatientSortedByName() throws SQLException;

    default void emptyArrayList() throws SQLException {
    }

    //Do not implement these methods in PatientServiceImplArraylist.java class
    default void updatePatient(PatientDTO patientDTO) throws SQLException {}

    default void deletePatient(int patientId) throws SQLException {}

    default PatientDTO getPatientById(int patientId) throws SQLException {
        return null;
    }

    //Do not implement these methods in PatientServiceImplArraylist.java and PatientServiceImplJdbc.java class
    //Do not implement this method until day-13
    default public void modifyPatientDetails(PatientDTO patientDTO) throws SQLException { }
}
