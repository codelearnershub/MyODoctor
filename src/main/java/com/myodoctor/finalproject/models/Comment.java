package com.myodoctor.finalproject.models;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private Patient patient;

    private Date date;

    @Column(nullable = false)
    private String content;
}