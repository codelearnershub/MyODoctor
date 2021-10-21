package com.myodoctor.finalproject.services.Implementations;

import com.myodoctor.finalproject.models.Address;
import com.myodoctor.finalproject.models.Patient;
import com.myodoctor.finalproject.models.Person;
import com.myodoctor.finalproject.models.RegisterModel.PatientRegistrationModel;
import com.myodoctor.finalproject.models.RegisterModel.PersonRegisterModel;
import com.myodoctor.finalproject.models.validations.PersonFormValidations;
import com.myodoctor.finalproject.repositories.IPatientRepositories;
import com.myodoctor.finalproject.services.Interfaces.IPatientService;
import com.myodoctor.finalproject.services.Interfaces.IPersonServices;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Service
public class PatientServices  implements IPatientService{

    PersonFormValidations formValidations;
    final IPatientRepositories patientRepositories;
    final IPersonServices personServices;

    public PatientServices(IPatientRepositories patientRepositories, IPersonServices personServices) {
        this.patientRepositories = patientRepositories;
        this.personServices = personServices;
    }

    public boolean createPatient(RedirectAttributes redirectAttributes, Address address, PersonRegisterModel personModel, PatientRegistrationModel patientModel) {
        //Person Validations
        if(formValidations.validate(redirectAttributes,personModel)) {
            //Patient Validations

            String role = "patient";

            var newPerson = personServices.createPerson(address,personModel, role);
            Patient patient = new Patient(newPerson, patientModel.getWeight(), patientModel.getHeight(), patientModel.getBloodGroup(), patientModel.getGenotype(), patientModel.getWorkId(), patientModel.getPatientHospitalId());
            patientRepositories.save(patient);
            return true;
        }
        return true;
    }

    public boolean disablePatient(int id) {
        if (personServices.disablePerson(id)) {
            System.out.println("Patient Disabled Successfully");
            return true;
        };
        return true;
    }

    public boolean update(int id,Address address,PersonRegisterModel personModel, PatientRegistrationModel patientModel) {
        personServices.update(id,address,personModel);
        Patient patient = patientRepositories.findById(id).get();

        patient.setBloodGroup(patientModel.getBloodGroup());
        patient.setGenotype(patientModel.getGenotype());
        patient.setHeight(patientModel.getHeight());
        patient.setWeight(patientModel.getWeight());
        patient.setWorkId(patientModel.getWorkId());

        patientRepositories.save(patient);
        return true;
    }

    public boolean getAllPatients(Model model){
        var allPatients =  patientRepositories.findAll();
        for (var patient: allPatients) {
            model.addAttribute("patients",patient);
        }
        return true;
    }
}