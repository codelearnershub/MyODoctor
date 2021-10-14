package com.myodoctor.finalproject.models;

import com.myodoctor.finalproject.enums.StaffType;

import javax.persistence.*;

@Entity
public class Staff {
    @Id
    private int id;

    @OneToOne
    private Person person;

    private StaffType type;
}
