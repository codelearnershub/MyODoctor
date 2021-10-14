package com.myodoctor.finalproject.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Records {
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
}