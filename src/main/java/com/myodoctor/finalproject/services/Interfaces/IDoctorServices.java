package com.myodoctor.finalproject.services.Interfaces;

import com.myodoctor.finalproject.models.Person;
import com.myodoctor.finalproject.models.RegisterModel.PersonRegisterModel;

public interface IDoctorServices {
    boolean createDoctor(Person person);
    boolean disableDoctor(int id);
    boolean update(int id, PersonRegisterModel personModel);
}
