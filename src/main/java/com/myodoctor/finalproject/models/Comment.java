package com.myodoctor.finalproject.models;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
public class Comment {
    public Comment() {
    }

    public Comment(Patient patient, Date date, String content) {
        this.patient = patient;
        this.date = date;
        this.content = content;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private Patient patient;

    private Date date;

    @Column(nullable = false)
    private String content;

    public int getId() {
        return id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}