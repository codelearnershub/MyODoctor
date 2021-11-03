package com.myodoctor.finalproject.controller;

import com.myodoctor.finalproject.models.Address;
import com.myodoctor.finalproject.models.RegisterModel.PatientRegistrationModel;
import com.myodoctor.finalproject.models.RegisterModel.PersonRegisterModel;
import com.myodoctor.finalproject.repositories.IPatientRepositories;
import com.myodoctor.finalproject.services.Implementations.PatientServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PatientController {

    final IPatientRepositories patientRepositories;
    final PatientServices patientServices;

    public PatientController(IPatientRepositories patientRepositories, PatientServices patientServices) {
        this.patientRepositories = patientRepositories;
        this.patientServices = patientServices;
    }

    @GetMapping("/patient/create")
        public String create() {
            return "/PatientView/createPatient";
        }

    @PostMapping("/patients/create")
    public String addPatient(RedirectAttributes redirectAttributes, Address address,PersonRegisterModel personModel,PatientRegistrationModel patientModel) {
        if ( patientServices.createPatient(redirectAttributes,address, personModel,patientModel)) {
            return "redirect:/login";
        }
        return "redirect:/patient/create";
    }

    @GetMapping("/patients/allPatients")
    public String allPatients(Model model) {
        var patient = patientServices.getAllPatients(model);
        model.addAttribute("patient" , patient);
        return "PatientView/allPatientPage";
    }
    @GetMapping("/patients/updatePatientDetails{id}")
    public String updatePatient(@PathVariable("id") int id,Address address,PersonRegisterModel personModel, PatientRegistrationModel patientModel) {
        patientServices.update(id,address, personModel, patientModel);
            return "redirect:/patients/allPatients";
    }

    @GetMapping("/patients/softDelete{id}")
    public String softDeletePatient(@PathVariable("id") int id) {
    patientServices.disablePatient(id);
        return "redirect:/patients/allPatients";
    }

    @GetMapping("/patients/seePatientDetails/{id}")
    public String details(@PathVariable int id,Model models) {
        var patient = patientRepositories.findById(id).get();
        models.addAttribute("patientDetails", patient);
        return "patients/patientDetails";
    }
}
