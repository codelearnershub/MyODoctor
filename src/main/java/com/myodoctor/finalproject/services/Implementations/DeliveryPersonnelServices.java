package com.myodoctor.finalproject.services.Implementations;

import com.myodoctor.finalproject.models.Address;
import com.myodoctor.finalproject.models.DeliveryPersonnel;
import com.myodoctor.finalproject.models.RegisterModel.DeliveryPersonnelRegistrationModel;
import com.myodoctor.finalproject.models.RegisterModel.PersonRegisterModel;
import com.myodoctor.finalproject.models.Route;
import com.myodoctor.finalproject.repositories.IDeliveryPersonnelRepositories;
import com.myodoctor.finalproject.repositories.IRouteRepositories;
import com.myodoctor.finalproject.services.Interfaces.IDeliveryPersonnelService;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Service
public class DeliveryPersonnelServices implements IDeliveryPersonnelService {

    final IRouteRepositories routeRepositories;
    final IDeliveryPersonnelRepositories deliveryPersonnelRepositories;
    final StaffServices staffServices;
    final PersonServices personServices;

    public DeliveryPersonnelServices(IRouteRepositories routeRepositories, IDeliveryPersonnelRepositories deliveryPersonnelRepositories, StaffServices staffServices, PersonServices personServices) {
        this.routeRepositories = routeRepositories;
        this.deliveryPersonnelRepositories = deliveryPersonnelRepositories;
        this.staffServices = staffServices;
        this.personServices = personServices;
    }

    public boolean createDeliveryPersonnel(RedirectAttributes redirectAttributes,DeliveryPersonnelRegistrationModel deliveryPersonnelModel, Address address, PersonRegisterModel personModel) {
        String role = "deliveryPersonnel";
        var newStaff = staffServices.createStaff(address,personModel,redirectAttributes,role);
        Route route = new Route(deliveryPersonnelModel.getRoute(),deliveryPersonnelModel.getDescription());
        routeRepositories.save(route);
        var deliveryPersonnel = new DeliveryPersonnel(newStaff,route);
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
        deliveryPersonnel.getStaff().getPerson().setDateOfBirth(personModel.getDateOfBirth());
        deliveryPersonnel.getStaff().getPerson().setHomePhoneNo(personModel.getHomePhoneNo());
        deliveryPersonnel.getStaff().getPerson().setWorkPhoneNo(personModel.getWorkPhoneNo());
        deliveryPersonnel.getStaff().getPerson().setMobileNo(personModel.getMobileNo());

        deliveryPersonnel.getStaff().getPerson().setGender(personModel.getGender());
        deliveryPersonnel.getStaff().getPerson().setEmail(personModel.getEmail());
        return true;
    }

    @GetMapping("/users/allDeliveryPersonnel")
    public Iterable<DeliveryPersonnel> getAllDeliveryPersonnel(Model model){
        return deliveryPersonnelRepositories.findAll();
    }
}