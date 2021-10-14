package com.myodoctor.finalproject.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Doctor {
    @Id
    private int id;

    @OneToOne
    private  Staff staff;

    @Column(nullable = false)
    private String biography;

    @Column(nullable = false)
    private String qualifications;

    private String documentURLs;

    @OneToOne
    private Department department;

}
