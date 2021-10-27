package com.myodoctor.finalproject.controller;

import com.myodoctor.finalproject.models.Address;
import com.myodoctor.finalproject.models.RegisterModel.DoctorRegistrationModel;
import com.myodoctor.finalproject.models.RegisterModel.PersonRegisterModel;
import com.myodoctor.finalproject.repositories.IDepartmentRepositories;
import com.myodoctor.finalproject.repositories.IDoctorRepositories;
import com.myodoctor.finalproject.services.Interfaces.IDoctorServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class DoctorController {
    final IDoctorRepositories doctorRepositories;
    final IDepartmentRepositories departmentRepositories;
    final IDoctorServices doctorServices;

    public DoctorController(IDoctorRepositories doctorRepositories, IDepartmentRepositories departmentRepositories, IDoctorServices doctorServices) {
        this.doctorRepositories = doctorRepositories;
        this.departmentRepositories = departmentRepositories;
        this.doctorServices = doctorServices;
    }

    @GetMapping("/doctor/create")
    public String create(Model model) {
        model.addAttribute("availableDepartment", departmentRepositories.findAll());
        return "/DoctorView/createDoctor";
    }

    @PostMapping("/doctors/create")
    public String addDoctor(RedirectAttributes redirectAttributes, Address address, PersonRegisterModel personModel, DoctorRegistrationModel doctorModel) {

        if (doctorServices.createDoctor( doctorModel,address,personModel,redirectAttributes)){
            return "redirect:/login";
        }
        return "redirect:/patient/create";
    }

    @GetMapping("/doctors/allDoctors")
    public String allDoctors(Model model) {
        var doctor = doctorServices.getAllDoctors(model);
        model.addAttribute("doctors" , doctor);
        return "PatientView/allPatientPage";
    }
    @GetMapping("/patients/updateDoctorDetails{id}")
    public String update(int id, Address address, DoctorRegistrationModel doctorRegistrationModel, PersonRegisterModel personModel) {
        doctorServices.update(id,address,doctorRegistrationModel,personModel);
        return "redirect:/patients/allPatients";
    }

    @GetMapping("/doctors/softDelete{id}")
    public String softDeletePatient(@PathVariable("id") int id) {
        doctorServices.disableDoctor(id);
        return "redirect:/doctors/allDoctors";
    }

    @GetMapping("/doctors/seeDoctorDetails/{id}")
    public String details(@PathVariable int id,Model models) {
        var patient = doctorRepositories.findById(id).get();
        models.addAttribute("patientDetails", patient);
        return "DoctorView/doctorDetails";
    }
}