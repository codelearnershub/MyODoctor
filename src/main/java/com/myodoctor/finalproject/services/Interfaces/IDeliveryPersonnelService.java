package com.myodoctor.finalproject.services.Interfaces;

import com.myodoctor.finalproject.models.Address;
import com.myodoctor.finalproject.models.Person;
import com.myodoctor.finalproject.models.RegisterModel.DeliveryPersonnelRegistrationModel;
import com.myodoctor.finalproject.models.RegisterModel.PersonRegisterModel;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface IDeliveryPersonnelService {
    boolean createDeliveryPersonnel(RedirectAttributes redirectAttributes,DeliveryPersonnelRegistrationModel deliveryPersonnelModel, Address address, PersonRegisterModel personModel);
    boolean disablePatient(int id);
    public boolean update(int id,DeliveryPersonnelRegistrationModel deliveryPersonnelModel,Address address,PersonRegisterModel personModel);
}
