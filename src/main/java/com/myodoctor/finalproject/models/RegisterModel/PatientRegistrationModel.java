package com.myodoctor.finalproject.models.RegisterModel;

import com.myodoctor.finalproject.models.Person;

public class PatientRegistrationModel {

    private double weight;
    private double height;
    private String bloodGroup;
    private String genotype;
    private String workId;
//    private String patientHospitalId;

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getGenotype() {
        return genotype;
    }

    public void setGenotype(String genotype) {
        this.genotype = genotype;
    }

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId;
    }

//    public String getPatientHospitalId() {
//        return patientHospitalId;
//    }
//
//    public void setPatientHospitalId(String patientHospitalId) {
//        this.patientHospitalId = patientHospitalId;
//    }

}
