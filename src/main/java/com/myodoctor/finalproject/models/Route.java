package com.myodoctor.finalproject.models;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private String route;

    private String description;

}
