package com.edutech.progressive.entity;

import java.util.Date;
import javax.persistence.*;

@Entity
public class Billing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int billing_id;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @Column(nullable = false)
    private double amount;

    @Column(nullable = false)
    private Date date_of_issue;

    private Date due_date;

    @Column(nullable = false)
    private String status;

    public Billing() {}

    public Billing(Patient patient, double amount, Date date_of_issue, Date due_date, String status) {
        this.patient = patient;
        this.amount = amount;
        this.date_of_issue = date_of_issue;
        this.due_date = due_date;
        this.status = status;
    }

    public Billing(int billing_id, Patient patient, double amount, Date date_of_issue, Date due_date, String status) {
        this.billing_id = billing_id;
        this.patient = patient;
        this.amount = amount;
        this.date_of_issue = date_of_issue;
        this.due_date = due_date;
        this.status = status;
    }

    public int getBillingId() {
        return billing_id;
    }

    public void setBillingId(int billing_id) {
        this.billing_id = billing_id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDateOfIssue() {
        return date_of_issue;
    }

    public void setDateOfIssue(Date date_of_issue) {
        this.date_of_issue = date_of_issue;
    }

    public Date getDueDate() {
        return due_date;
    }

    public void setDueDate(Date due_date) {
        this.due_date = due_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
