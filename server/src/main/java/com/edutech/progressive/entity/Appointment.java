package com.edutech.progressive.entity;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appointment_id;
    
    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "clinic_id", nullable = false)
    private Clinic clinic;

    @Column(nullable = false)
    private Date appointment_date;
    @Column(nullable = false)
    private String status;
    private String purpose;
    
    public Appointment() {
    }

    public Appointment(Patient patient, Clinic clinic, Date appointment_date, String status, String purpose) {
        this.patient = patient;
        this.clinic = clinic;
        this.appointment_date = appointment_date;
        this.status = status;
        this.purpose = purpose;
    }

    public Appointment(int appointment_id, Patient patient, Clinic clinic, Date appointment_date,
            String status, String purpose) {
        this.appointment_id = appointment_id;
        this.patient = patient;
        this.clinic = clinic;
        this.appointment_date = appointment_date;
        this.status = status;
        this.purpose = purpose;
    }

    public int getAppointmentId() {
        return appointment_id;
    }

    public void setAppointmentId(int appointment_id) {
        this.appointment_id = appointment_id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Clinic getClinic() {
        return clinic;
    }

    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }

    public Date getAppointmentDate() {
        return appointment_date;
    }

    public void setAppointmentDate(Date appointment_date) {
        this.appointment_date = appointment_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

}