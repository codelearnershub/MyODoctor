package com.myodoctor.finalproject.services.Interfaces;

import com.myodoctor.finalproject.models.Person;
import com.myodoctor.finalproject.models.RegisterModel.PatientRegistrationModel;
import com.myodoctor.finalproject.models.RegisterModel.PersonRegisterModel;

public interface IPatientService {
    boolean createPatient(PersonRegisterModel personModel,PatientRegistrationModel patientModel);
    boolean disablePatient(int id);
    boolean update(int id,PersonRegisterModel personModel, PatientRegistrationModel patientModel);
}
