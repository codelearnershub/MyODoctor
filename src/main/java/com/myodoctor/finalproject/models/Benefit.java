package com.myodoctor.finalproject.models;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class Benefit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private String name;

    @NotNull
    private String description;

}