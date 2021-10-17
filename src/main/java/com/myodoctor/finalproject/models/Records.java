package com.myodoctor.finalproject.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Records {
    public Records() {
    }

    public Records(Patient patient, Date appointment_Date, String doctorNote, Doctor doctor) {
        this.patient = patient;
        this.appointment_Date = appointment_Date;
        this.doctorNote = doctorNote;
        this.doctor = doctor;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private Patient patient;

    private Date appointment_Date;

    @Column(nullable = false)
    private String doctorNote;

    @ManyToOne
    private  Doctor doctor;

    public int getId() {
        return id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Date getAppointment_Date() {
        return appointment_Date;
    }

    public void setAppointment_Date(Date appointment_Date) {
        this.appointment_Date = appointment_Date;
    }

    public String getDoctorNote() {
        return doctorNote;
    }

    public void setDoctorNote(String doctorNote) {
        this.doctorNote = doctorNote;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}