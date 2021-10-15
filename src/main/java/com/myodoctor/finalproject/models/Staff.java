package com.myodoctor.finalproject.models;

import com.myodoctor.finalproject.enums.StaffType;

import javax.persistence.*;

@Entity
public class Staff {
    public Staff() {
    }

    public Staff(Person person, StaffType type) {
        this.id = person.getId();
        this.person = person;
        this.type = type;
    }

    @Id
    private int id;

    @OneToOne
    private Person person;

    private StaffType type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public StaffType getType() {
        return type;
    }

    public void setType(StaffType type) {
        this.type = type;
    }
}
