package com.edutech.progressive.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.progressive.dto.DoctorDTO;
import com.edutech.progressive.entity.Doctor;
import com.edutech.progressive.exception.DoctorAlreadyExistsException;
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
    public List<DoctorDTO> getAllDoctors() throws SQLException {
        List<Doctor> doctors = doctorRepository.findAll();
        List<DoctorDTO> doctorDTOs = new ArrayList<>();
        for(Doctor d : doctors){
            doctorDTOs.add(convertToDto(d));
        }
        return doctorDTOs;
    }

    @Override
    public Integer addDoctor(DoctorDTO doctorDTO) throws SQLException {
        Doctor doctor = convertToEntity(doctorDTO);
        Optional<Doctor> d = doctorRepository.findByEmail(doctor.getEmail());
        if(d.isPresent()){
            throw new DoctorAlreadyExistsException("Doctor already exists");
        }
        doctorRepository.save(doctor);
        return doctor.getDoctorId();
    }

    @Override
    public List<DoctorDTO> getDoctorSortedByExperience() throws SQLException {
        List<Doctor> doctors = doctorRepository.findAllByOrderByYearsOfExperienceAsc();
        List<DoctorDTO> doctorDTOs = new ArrayList<>();
        for(Doctor d : doctors){
            doctorDTOs.add(convertToDto(d));
        }
        return doctorDTOs;
    }

    public void updateDoctor(DoctorDTO doctorDTO) throws SQLException {
        Doctor doctor = convertToEntity(doctorDTO);
        doctorRepository.save(doctor);
    }

    public void deleteDoctor(int doctorId) throws SQLException {
        Optional<Doctor> doctor = doctorRepository.findById(doctorId);
        if(doctor.isPresent()){
            clinicRepository.deleteByDoctorId(doctorId);
            doctorRepository.deleteById(doctorId);
        }
    }

    public DoctorDTO getDoctorById(int doctorId) throws SQLException {
        Optional<Doctor> doctor = doctorRepository.findByDoctorId(doctorId);
        if(doctor.isPresent()){
            return convertToDto(doctor.get());
        }
        return null;
    }

    public Doctor convertToEntity(DoctorDTO dto){
        Doctor doctor = new Doctor();

        doctor.setDoctorId(dto.getDoctorId());
        doctor.setFullName(dto.getFullName());
        doctor.setSpecialty(dto.getSpecialty());
        doctor.setContactNumber(dto.getContactNumber());
        doctor.setEmail(dto.getEmail());
        doctor.setYearsOfExperience(dto.getYearsOfExperience());
        return doctor;
    }

    public DoctorDTO convertToDto(Doctor doctor){
        DoctorDTO doctorDTO = new DoctorDTO();

        doctorDTO.setDoctorId(doctor.getDoctorId());
        doctorDTO.setFullName(doctor.getFullName());
        doctorDTO.setSpecialty(doctor.getSpecialty());
        doctorDTO.setContactNumber(doctor.getContactNumber());
        doctorDTO.setEmail(doctor.getEmail());
        doctorDTO.setYearsOfExperience(doctor.getYearsOfExperience());
        return doctorDTO;
    }

}