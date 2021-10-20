package com.myodoctor.finalproject.services.Implementations;

import com.myodoctor.finalproject.models.DeliveryPersonnel;
import com.myodoctor.finalproject.models.Person;
import com.myodoctor.finalproject.models.RegisterModel.DeliveryPersonnelRegistrationModel;
import com.myodoctor.finalproject.models.RegisterModel.PersonRegisterModel;
import com.myodoctor.finalproject.repositories.IDeliveryPersonnelRepositories;
import com.myodoctor.finalproject.services.Interfaces.IDeliveryPersonnelService;
import com.myodoctor.finalproject.services.Interfaces.IStaffServices;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class DeliveryPersonnelServices implements IDeliveryPersonnelService {

    IDeliveryPersonnelRepositories deliveryPersonnelRepositories;
    StaffServices staffServices;
    DeliveryPersonnelRegistrationModel deliveryPersonnelModel;
    PersonServices personServices;

    public DeliveryPersonnelServices(IDeliveryPersonnelRepositories deliveryPersonnelRepositories) {
        this.deliveryPersonnelRepositories = deliveryPersonnelRepositories;
    }

    public boolean createDeliveryPersonnel(Person person) {
        String role = "deliveryPersonnel";
        staffServices.createStaff(role);
        DeliveryPersonnel deliveryPersonnel = new DeliveryPersonnel(deliveryPersonnelModel.getStaff(),deliveryPersonnelModel.getRoute());
        deliveryPersonnelRepositories.save(deliveryPersonnel);
        return true;
    }

    public boolean disablePatient(int id) {
        if (personServices.disablePerson(id)) {
            System.out.println("DeliveryPersonnel Disabled Successfully");
            return true;
        };
        return true;
    }

    public boolean update(int id,PersonRegisterModel personModel) {
        personServices.update(id, personModel);
        DeliveryPersonnel deliveryPersonnel = deliveryPersonnelRepositories.findById(id).get();
        deliveryPersonnel.setStaff(deliveryPersonnelModel.getStaff());
        deliveryPersonnel.setRoute(deliveryPersonnelModel.getRoute());
        deliveryPersonnelRepositories.save(deliveryPersonnel);
        return true;
    }

    @GetMapping("/users/allDeliveryPersonnel")
    public String getAllDeliveryPersonnel(Model model){
        model.addAttribute("patients", deliveryPersonnelRepositories.findAll());
        return "";
    }
}