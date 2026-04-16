package com.edutech.progressive.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import com.edutech.progressive.entity.Clinic;
import com.edutech.progressive.exception.ClinicAlreadyExistsException;
import com.edutech.progressive.repository.ClinicRepository;
import com.edutech.progressive.service.ClinicService;

@Service
public class ClinicServiceImplJpa implements ClinicService {

    ClinicRepository clinicRepository;
    
    public ClinicServiceImplJpa(ClinicRepository clinicRepository) {
        this.clinicRepository = clinicRepository;
    }

    @Override
    public List<Clinic> getAllClinics() throws SQLException {
        return clinicRepository.findAll();
    }

    @Override
    public Clinic getClinicById(int clinicId) throws SQLException {
        return clinicRepository.findByClinicId(clinicId);
    }

    @Override
    public Integer addClinic(Clinic clinic) throws SQLException {
        if(clinicRepository.findByClinicName(clinic.getClinicName()).isPresent()){
            throw new ClinicAlreadyExistsException("Clinic already exists");
        }
        Clinic saved = clinicRepository.save(clinic);
        return saved.getClinicId();
    }

    @Override
    public void updateClinic(Clinic clinic) throws SQLException {
        clinicRepository.save(clinic);
    }

    @Override
    public void deleteClinic(int clinicId) throws SQLException {
        Optional<Clinic> c = clinicRepository.findById(clinicId);
        if(c.isPresent()){
            clinicRepository.deleteById(clinicId);
        }
    }

    public List<Clinic> getAllClinicByLocation(String location) throws SQLException {
        return clinicRepository.findAllByLocation(location);
    }

    public List<Clinic> getAllClinicByDoctorId(int doctorId) throws SQLException {
        return clinicRepository.findAllByDoctorId(doctorId);
    }

}