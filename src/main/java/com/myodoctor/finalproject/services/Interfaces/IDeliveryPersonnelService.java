package com.myodoctor.finalproject.services.Interfaces;

import com.myodoctor.finalproject.models.Person;
import com.myodoctor.finalproject.models.RegisterModel.PersonRegisterModel;

public interface IDeliveryPersonnelService {
    boolean createDeliveryPersonnel(Person person);
    boolean disablePatient(int id);
    boolean update(int id, PersonRegisterModel personModel);

}
