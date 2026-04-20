package com.edutech.progressive.controller;

import com.edutech.progressive.dto.PatientDTO;
import com.edutech.progressive.entity.Patient;
import com.edutech.progressive.service.PatientService;
// import com.edutech.progressive.service.impl.PatientServiceImplArraylist;
// import com.edutech.progressive.service.impl.PatientServiceImplJdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    PatientService patientService;
    

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public ResponseEntity<List<PatientDTO>> getAllPatients() {
        try {
            return new ResponseEntity<>(patientService.getAllPatients(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{patientID}")
    public ResponseEntity<PatientDTO> getPatientById(@PathVariable("patientID") int patientId) {
        try {
            return new ResponseEntity<>(patientService.getPatientById(patientId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Integer> addPatient(@RequestBody PatientDTO patient) {
        try {
            return new ResponseEntity<>(patientService.addPatient(patient), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{patientID}")
    public ResponseEntity<Void> updatePatient(@PathVariable("patientID") int patientId, @RequestBody PatientDTO patient) {
        try {
            patient.setPatientId(patientId);
            patientService.updatePatient(patient);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{patientID}")
    public ResponseEntity<Void> deletePatient(@PathVariable("patientID") int patientId) {
        try {
            patientService.deletePatient(patientId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/fromArrayList")
    public ResponseEntity<List<PatientDTO>> getAllPatientFromArrayList() {
        // return new ResponseEntity<>(HttpStatus.OK);
        try {
            return new ResponseEntity<>(patientService.getAllPatients(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/toArrayList")
    public ResponseEntity<Void> addPatientToArrayList() {
        //return new ResponseEntity<>(HttpStatus.CREATED);
        try {
            patientService.addPatient(null);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/fromArrayList/sorted")
    public ResponseEntity<List<PatientDTO>> getAllPatientSortedByNameFromArrayList() {
        //return new ResponseEntity<>(HttpStatus.OK);
        try {
            return new ResponseEntity<>(patientService.getAllPatientSortedByName(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}