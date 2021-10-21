package com.myodoctor.finalproject.services.Interfaces;

import com.myodoctor.finalproject.controller.PersonController;
import com.myodoctor.finalproject.models.Address;
import com.myodoctor.finalproject.models.Person;
import com.myodoctor.finalproject.models.RegisterModel.PatientRegistrationModel;
import com.myodoctor.finalproject.models.RegisterModel.PersonRegisterModel;
import org.springframework.stereotype.Service;

@Service
public interface IPersonServices {
    Person createPerson(Address address, PersonRegisterModel personModel, String role);
    boolean update(int id,Address address,PersonRegisterModel personModel);
    boolean setValues(Address address,Person person,PersonRegisterModel personModel);
    boolean disablePerson(int id);
}