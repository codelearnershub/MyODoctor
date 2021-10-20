package com.myodoctor.finalproject.services.Implementations;


import com.myodoctor.finalproject.models.Department;
import com.myodoctor.finalproject.models.Doctor;
import com.myodoctor.finalproject.models.Person;
import com.myodoctor.finalproject.models.RegisterModel.DoctorRegistrationModel;
import com.myodoctor.finalproject.models.RegisterModel.PersonRegisterModel;
import com.myodoctor.finalproject.models.Staff;
import com.myodoctor.finalproject.repositories.IDoctorRepositories;
import com.myodoctor.finalproject.services.Interfaces.IDoctorServices;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class DoctorServices implements IDoctorServices {
    IDoctorRepositories doctorRepositories;
    StaffServices staffServices;
    DoctorRegistrationModel doctorRegistrationModel;
    PersonServices personServices;

    public DoctorServices(IDoctorRepositories doctorRepositories) {
        this.doctorRepositories = doctorRepositories;
//        this.staffServices = staffServices;
//        this.doctorRegistrationModel = doctorRegistrationModel;
//        this.personServices = personServices;
    }

    public boolean createDoctor(Person person) {
        String role = "doctor";
        staffServices.createStaff(role);
        Doctor doctor = new Doctor();
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

    public boolean update(int id, PersonRegisterModel personModel) {

        personServices.update(id, personModel);
        Doctor doctor = doctorRepositories.findById(id).get();
        doctor.setStaff(doctorRegistrationModel.getStaff());
        doctor.setBiography(doctorRegistrationModel.getBiography());
        doctor.setQualifications(doctorRegistrationModel.getQualifications());
        doctor.setDocumentURLs(doctorRegistrationModel.getDocumentURLs());
        doctor.setDepartment(doctorRegistrationModel.getDepartment());

        return true;
    }

    @GetMapping("/users/allDoctors")
    public String getAllDeliveryPersonnel(Model model){
        model.addAttribute("patients", doctorRepositories.findAll());
        return "";
    }
}