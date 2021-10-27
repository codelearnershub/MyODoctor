package com.myodoctor.finalproject.models.RegisterModel;

import com.myodoctor.finalproject.models.Address;
import com.myodoctor.finalproject.models.Language;
import com.myodoctor.finalproject.models.Role;
import com.sun.istack.NotNull;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

public class PersonRegisterModel {
    private String username;
    private String firstName;
    private String lastName;
    private String middleName;
//    private Address address;
//    private List<Language> language;
    private String dateOfBirth;
    private String homePhoneNo;
    private String workPhoneNo;
    private String mobileNo;
    private String gender;
    private MultipartFile profilePictureURL;
    private String email;
    private boolean disabled;
    private String password;
    private String confirmPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

//    public List<Language> getLanguage() {
//        return language;
//    }
//
//    public void setLanguage(List<Language> language) {
//        this.language = language;
//    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getHomePhoneNo() {
        return homePhoneNo;
    }

    public void setHomePhoneNo(String homePhoneNo) {
        this.homePhoneNo = homePhoneNo;
    }

    public String getWorkPhoneNo() {
        return workPhoneNo;
    }

    public void setWorkPhoneNo(String workPhoneNo) {
        this.workPhoneNo = workPhoneNo;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public MultipartFile getProfilePictureURL() {
        return profilePictureURL;
    }

    public void setProfilePictureURL(MultipartFile profilePictureURL) {
        this.profilePictureURL = profilePictureURL;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setActive(boolean disabled) {
        disabled = disabled;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    //    public List<Role> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(List<Role> roles) {
//        this.roles = roles;
//    }
}
