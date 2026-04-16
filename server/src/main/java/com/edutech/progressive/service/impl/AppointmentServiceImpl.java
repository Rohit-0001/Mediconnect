package com.edutech.progressive.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.progressive.entity.Appointment;
import com.edutech.progressive.entity.Clinic;
import com.edutech.progressive.entity.Patient;
import com.edutech.progressive.repository.AppointmentRepository;
import com.edutech.progressive.repository.ClinicRepository;
import com.edutech.progressive.repository.PatientRepository;
import com.edutech.progressive.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    AppointmentRepository appointmentRepository;

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    } 

    @Override
    public int createAppointment(Appointment appointment) {
        Appointment app = appointmentRepository.save(appointment);
        return app.getAppointmentId();
    }

    @Override
    public void updateAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);
    }

    @Override
    public Appointment getAppointmentById(int appointmentId) {
        Optional<Appointment> app = appointmentRepository.findById(appointmentId);
        if(app.isPresent()){
            return app.get();
        }
        return null;
    }

    @Override
    public List<Appointment> getAppointmentByClinic(int clinicId) {
        return appointmentRepository.findByClinic_ClinicId(clinicId);
    }

    @Override
    public List<Appointment> getAppointmentByPatient(int patientId) {
        return appointmentRepository.findByPatient_PatientId(patientId);
    }

    @Override
    public List<Appointment> getAppointmentByStatus(String status) {
        return appointmentRepository.findByStatus(status);
    }

}