package com.edutech.progressive.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.edutech.progressive.entity.Clinic;
import com.edutech.progressive.service.ClinicService;

@Service
public class ClinicServiceImplJpa implements ClinicService {

    @Override
    public List<Clinic> getAllClinics() throws SQLException {
        return null;
    }

    @Override
    public Clinic getClinicById(int clinicId) throws SQLException {
        return null;
    }

    @Override
    public Integer addClinic(Clinic clinic) throws SQLException {
        return -1;
    }

    @Override
    public void updateClinic(Clinic clinic) throws SQLException {
        
    }

    @Override
    public void deleteClinic(int clinicId) throws SQLException {
        
    }

}