package com.myodoctor.finalproject.services.Interfaces;

import com.myodoctor.finalproject.models.Address;
import com.myodoctor.finalproject.models.Person;
import com.myodoctor.finalproject.models.RegisterModel.DoctorRegistrationModel;
import com.myodoctor.finalproject.models.RegisterModel.PersonRegisterModel;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface IDoctorServices {
    public boolean createDoctor(DoctorRegistrationModel doctorRegistrationModel,Address address,PersonRegisterModel personModel,RedirectAttributes redirectAttributes,Person person);
    boolean disableDoctor(int id);
    boolean update(int id, Address address, DoctorRegistrationModel doctorRegistrationModel, PersonRegisterModel personModel);
}
