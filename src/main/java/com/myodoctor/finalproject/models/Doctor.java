package com.myodoctor.finalproject.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Doctor {
    public Doctor() {
    }

    public Doctor(Staff staff, String biography, String qualifications, String documentURLs, Department department) {
        this.id = staff.getId();
        this.staff = staff;
        this.biography = biography;
        this.qualifications = qualifications;
        this.documentURLs = documentURLs;
        this.department = department;
    }

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

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getQualifications() {
        return qualifications;
    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }

    public String getDocumentURLs() {
        return documentURLs;
    }

    public void setDocumentURLs(String documentURLs) {
        this.documentURLs = documentURLs;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
