package com.myodoctor.finalproject.services.Implementations;

import com.myodoctor.finalproject.models.Address;
import com.myodoctor.finalproject.models.Doctor;
import com.myodoctor.finalproject.models.RegisterModel.DoctorRegistrationModel;
import com.myodoctor.finalproject.models.RegisterModel.PersonRegisterModel;
import com.myodoctor.finalproject.repositories.IDepartmentRepositories;
import com.myodoctor.finalproject.repositories.IDoctorRepositories;
import com.myodoctor.finalproject.services.Interfaces.IDoctorServices;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

@Service
public class DoctorServices implements IDoctorServices {
    final IDoctorRepositories doctorRepositories;
    final IDepartmentRepositories departmentRepositories;
    final StaffServices staffServices;
    final PersonServices personServices;

    public DoctorServices(IDepartmentRepositories departmentRepositories, IDoctorRepositories doctorRepositories, StaffServices staffServices, PersonServices personServices) {
        this.doctorRepositories = doctorRepositories;
        this.departmentRepositories = departmentRepositories;
        this.staffServices = staffServices;
        this.personServices = personServices;
    }

    public boolean createDoctor(DoctorRegistrationModel doctorRegistrationModel,Address address,PersonRegisterModel personModel,RedirectAttributes redirectAttributes) {
        String role = "doctor";
        if(personServices.doctorValidate(redirectAttributes,personModel)) {
            var newStaff = staffServices.createStaff(address,personModel, redirectAttributes, role);
            var department = departmentRepositories.findByName(doctorRegistrationModel.getDepartment());

            Doctor doctor = new Doctor();
            doctor.setStaff(newStaff);
            doctor.setBiography(doctorRegistrationModel.getBiography());
            doctor.setQualifications(doctorRegistrationModel.getQualifications());

            String fileName = null;
            if (doctorRegistrationModel.getDocumentURLs() != null) {
                fileName = uploadDocument(doctorRegistrationModel.getDocumentURLs(), redirectAttributes);
            }
            doctor.setDocumentURLs(fileName);
            doctorRepositories.save(doctor);
            return true;
        }
        return true;
    }

    public boolean disableDoctor(int id) {
        if (personServices.disablePerson(id)) {
            System.out.println("Doctor Disabled Successfully");
            return true;
        };
        return true;
    }

    public boolean update(int id, Address address, DoctorRegistrationModel doctorRegistrationModel, PersonRegisterModel personModel) {
        personServices.update(id,address,personModel);

        Doctor doctor = doctorRepositories.findById(id).get();

        doctor.setStaff(doctorRegistrationModel.getStaff());
        doctor.setBiography(doctorRegistrationModel.getBiography());
        doctor.setQualifications(doctorRegistrationModel.getQualifications());
//        doctor.setDocumentURLs(doctorRegistrationModel.getDocumentURLs());

         var department = departmentRepositories.findByName(doctorRegistrationModel.getDepartment());
        doctor.setDepartment(department);
        return true;
    }

    public Iterable<Doctor> getAllDoctors(Model model){
        return doctorRepositories.findAll();
    }

    public String uploadDocument (MultipartFile file, RedirectAttributes redirectAttributes){
        final String UPLOAD_DIR = "C://Users//ESSIEN ABASIAMA//Documents//Abasi Complex [ programming ]//Java Personal practise//myodoctor//src//main//resources//static//profilePictures";
        try {
            String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
            Path copyLocation = Paths.get(UPLOAD_DIR + File.separator + fileName);
            Files.copy(file.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);
            return fileName;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}


