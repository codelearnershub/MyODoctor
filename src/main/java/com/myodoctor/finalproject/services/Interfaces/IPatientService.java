package com.myodoctor.finalproject.services.Interfaces;

import com.myodoctor.finalproject.models.Address;
import com.myodoctor.finalproject.models.RegisterModel.PatientRegistrationModel;
import com.myodoctor.finalproject.models.RegisterModel.PersonRegisterModel;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface IPatientService {
    boolean createPatient(RedirectAttributes redirectAttributes, Address address, PersonRegisterModel personModel, PatientRegistrationModel patientModel);
    boolean disablePatient(int id);
    boolean update(int id,Address address,PersonRegisterModel personModel,PatientRegistrationModel patientModel);
}
