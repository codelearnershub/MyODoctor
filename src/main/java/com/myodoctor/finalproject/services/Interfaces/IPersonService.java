package com.myodoctor.finalproject.services.Interfaces;

import com.myodoctor.finalproject.models.*;
import com.myodoctor.finalproject.models.RegisterModel.PersonRegisterModel;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


public interface IPersonService {
    Person createPerson(RedirectAttributes redirectAttributes,Address address,PersonRegisterModel personModel, String role,boolean staff);    boolean validate(RedirectAttributes redirectAttributes,PersonRegisterModel personModel);
    boolean update(int id, Address address, PersonRegisterModel personModel);
    boolean setValues(Person person,PersonRegisterModel personModel);
    boolean disablePerson(int id);
}