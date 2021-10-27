package com.myodoctor.finalproject.models.RegisterModel;

import com.myodoctor.finalproject.models.Staff;
import org.springframework.web.multipart.MultipartFile;

public class DoctorRegistrationModel {
    private Staff staff;
    private String biography;
    private String qualifications;
    private MultipartFile documentURLs;
    private String department;

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

    public MultipartFile getDocumentURLs() {
        return documentURLs;
    }

    public void setDocumentURLs(MultipartFile documentURLs) {
        this.documentURLs = documentURLs;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
