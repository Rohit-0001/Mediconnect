package com.edutech.progressive.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.progressive.entity.Doctor;
import com.edutech.progressive.repository.ClinicRepository;
import com.edutech.progressive.repository.DoctorRepository;
import com.edutech.progressive.service.DoctorService;

@Service
public class DoctorServiceImplJpa implements DoctorService {

    DoctorRepository doctorRepository;

    public DoctorServiceImplJpa(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Autowired
    ClinicRepository clinicRepository;

    @Override
    public List<Doctor> getAllDoctors() throws SQLException {
        return doctorRepository.findAll();
    }

    @Override
    public Integer addDoctor(Doctor doctor) throws SQLException {
        doctorRepository.save(doctor);
        return doctor.getDoctorId();
    }

    @Override
    public List<Doctor> getDoctorSortedByExperience() throws SQLException {
        return doctorRepository.findAllByOrderByYearsOfExperienceAsc();
    }

    public void updateDoctor(Doctor doctor) throws SQLException {
        Doctor existingDoctor = doctorRepository.findByDoctorId(doctor.getDoctorId()).orElse(null);
        if (existingDoctor != null) {
            existingDoctor.setFullName(doctor.getFullName());
            existingDoctor.setSpecialty(doctor.getSpecialty());
            existingDoctor.setYearsOfExperience(doctor.getYearsOfExperience());
            existingDoctor.setClinic(doctor.getClinic());
            doctorRepository.save(existingDoctor);
        }
    }

    public void deleteDoctor(int doctorId) throws SQLException {
        Optional<Doctor> doctor = doctorRepository.findById(doctorId);
        if(doctor.isPresent()){
            clinicRepository.deleteByDoctorId(doctorId);
            doctorRepository.deleteById(doctorId);
        }
    }

    public Doctor getDoctorById(int doctorId) throws SQLException {
        Optional<Doctor> doctor = doctorRepository.findByDoctorId(doctorId);
        if(doctor.isPresent()){
            return doctor.get();
        }
        return null;
    }

}