package com.myodoctor.finalproject.services.Implementations;

import com.myodoctor.finalproject.models.Address;
import com.myodoctor.finalproject.models.DeliveryPersonnel;
import com.myodoctor.finalproject.models.Person;
import com.myodoctor.finalproject.models.RegisterModel.DeliveryPersonnelRegistrationModel;
import com.myodoctor.finalproject.models.RegisterModel.PersonRegisterModel;
import com.myodoctor.finalproject.models.validations.PersonFormValidations;
import com.myodoctor.finalproject.repositories.IDeliveryPersonnelRepositories;
import com.myodoctor.finalproject.services.Interfaces.IDeliveryPersonnelService;
import com.myodoctor.finalproject.services.Interfaces.IStaffServices;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Service
public class DeliveryPersonnelServices implements IDeliveryPersonnelService {

    IDeliveryPersonnelRepositories deliveryPersonnelRepositories;
    StaffServices staffServices;

    PersonServices personServices;

    public DeliveryPersonnelServices(IDeliveryPersonnelRepositories deliveryPersonnelRepositories) {
        this.deliveryPersonnelRepositories = deliveryPersonnelRepositories;
    }

    public boolean createDeliveryPersonnel(RedirectAttributes redirectAttributes,DeliveryPersonnelRegistrationModel deliveryPersonnelModel, Address address, PersonRegisterModel personModel) {

        String role = "deliveryPersonnel";
        var newStaff = staffServices.createStaff(address,personModel,redirectAttributes,role);
        DeliveryPersonnel deliveryPersonnel = new DeliveryPersonnel(newStaff,deliveryPersonnelModel.getRoute());
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

    public boolean update(int id,DeliveryPersonnelRegistrationModel deliveryPersonnelModel,Address address,PersonRegisterModel personModel) {
        personServices.update(id,address, personModel);
        DeliveryPersonnel deliveryPersonnel = deliveryPersonnelRepositories.findById(id).get();

        deliveryPersonnel.getStaff().getPerson().setUsername(personModel.getUsername());
        deliveryPersonnel.getStaff().getPerson().setFirstName(personModel.getFirstName());
        deliveryPersonnel.getStaff().getPerson().setLastName(personModel.getLastName());
        deliveryPersonnel.getStaff().getPerson().setMiddleName(personModel.getMiddleName());

        address = new  Address();
        address.setCity(address.getCity());
        address.setCountry(address.getCountry());
        address.setStateProvinceCounty(address.getStateProvinceCounty());
        address.setStreetNumber(address.getStreetNumber());
        address.setZipPostalCode(address.getZipPostalCode());

        deliveryPersonnel.getStaff().getPerson().setAddress(address);
        deliveryPersonnel.getStaff().getPerson().setLanguage(personModel.getLanguage());
        deliveryPersonnel.getStaff().getPerson().setDateOfBirth(personModel.getDateOfBirth());
        deliveryPersonnel.getStaff().getPerson().setHomePhoneNo(personModel.getHomePhoneNo());
        deliveryPersonnel.getStaff().getPerson().setWorkPhoneNo(personModel.getWorkPhoneNo());
        deliveryPersonnel.getStaff().getPerson().setMobileNo(personModel.getMobileNo());

        deliveryPersonnel.getStaff().getPerson().setGender(personModel.getGender());
        deliveryPersonnel.getStaff().getPerson().setProfilePictureURL(personModel.getProfilePictureURL());
        deliveryPersonnel.getStaff().getPerson().setEmail(personModel.getEmail());

        deliveryPersonnel.setRoute(deliveryPersonnelModel.getRoute());
        return true;
    }

    @GetMapping("/users/allDeliveryPersonnel")
    public String getAllDeliveryPersonnel(Model model){
        model.addAttribute("patients", deliveryPersonnelRepositories.findAll());
        return "";
    }
}