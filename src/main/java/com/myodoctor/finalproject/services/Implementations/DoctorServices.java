package com.myodoctor.finalproject.services.Implementations;


import com.myodoctor.finalproject.models.*;
import com.myodoctor.finalproject.models.RegisterModel.DoctorRegistrationModel;
import com.myodoctor.finalproject.models.RegisterModel.PersonRegisterModel;
import com.myodoctor.finalproject.repositories.IDepartmentRepositories;
import com.myodoctor.finalproject.repositories.IDoctorRepositories;
import com.myodoctor.finalproject.services.Interfaces.IDoctorServices;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Service
public class DoctorServices implements IDoctorServices {
    IDoctorRepositories doctorRepositories;
    IDepartmentRepositories departmentRepositories;
    StaffServices staffServices;

    PersonServices personServices;

    public DoctorServices(IDepartmentRepositories departmentRepositories,IDoctorRepositories doctorRepositories) {
        this.doctorRepositories = doctorRepositories;
        this.departmentRepositories = departmentRepositories;
    }

    public boolean createDoctor(DoctorRegistrationModel doctorRegistrationModel,Address address,PersonRegisterModel personModel,RedirectAttributes redirectAttributes,Person person) {
        String role = "doctor";
        var newStaff = staffServices.createStaff(address,personModel, redirectAttributes, role);
        var department = departmentRepositories.findByName(doctorRegistrationModel.getDepartment());

        Doctor doctor = new Doctor(newStaff,doctorRegistrationModel.getBiography(),doctorRegistrationModel.getQualifications(),doctorRegistrationModel.getDocumentURLs(),department);

        doctorRepositories.save(doctor);
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
        doctor.setDocumentURLs(doctorRegistrationModel.getDocumentURLs());

         var department = departmentRepositories.findByName(doctorRegistrationModel.getDepartment());
        doctor.setDepartment(department);
        return true;
    }

    @GetMapping("/users/allDoctors")
    public String getAllDeliveryPersonnel(Model model){
        model.addAttribute("patients", doctorRepositories.findAll());
        return "";
    }
}