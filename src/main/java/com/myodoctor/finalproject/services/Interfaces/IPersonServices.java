package com.myodoctor.finalproject.services.Interfaces;

import com.myodoctor.finalproject.controller.PersonController;
import com.myodoctor.finalproject.models.Person;
import com.myodoctor.finalproject.models.RegisterModel.PatientRegistrationModel;
import com.myodoctor.finalproject.models.RegisterModel.PersonRegisterModel;
import org.springframework.stereotype.Service;

@Service
public interface IPersonServices {
    boolean createPerson(PersonRegisterModel personModel,String role);
    boolean update(int id,PersonRegisterModel personModel);
    boolean setValues(Person person,PersonRegisterModel personModel);
    boolean disablePerson(int id);
}