package com.myodoctor.finalproject.controller;

import com.myodoctor.finalproject.models.Address;
import com.myodoctor.finalproject.models.RegisterModel.DeliveryPersonnelRegistrationModel;
import com.myodoctor.finalproject.models.RegisterModel.PersonRegisterModel;
import com.myodoctor.finalproject.repositories.IDeliveryPersonnelRepositories;
import com.myodoctor.finalproject.repositories.IRouteRepositories;
import com.myodoctor.finalproject.services.Implementations.DeliveryPersonnelServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class DeliveryPersonnelController {
    final IRouteRepositories routeRepositories;
    final IDeliveryPersonnelRepositories deliveryPersonnelRepositories;
    final DeliveryPersonnelServices deliveryPersonnelServices;

    public DeliveryPersonnelController(IRouteRepositories routeRepositories, IDeliveryPersonnelRepositories deliveryPersonnelRepositories, DeliveryPersonnelServices deliveryPersonnelServices) {
        this.routeRepositories = routeRepositories;
        this.deliveryPersonnelRepositories = deliveryPersonnelRepositories;
        this.deliveryPersonnelServices = deliveryPersonnelServices;
    }

    @GetMapping("/deliveryPersonnel/create")
    public String create() {
        return "/DeliveryPersonnel/createDeliveryPersonnel";
    }

    @PostMapping("/deliveryPerson/create")
    public String addDeliveryPersonnel(RedirectAttributes redirectAttributes, DeliveryPersonnelRegistrationModel deliveryPersonnelModel, Address address, PersonRegisterModel personModel) {

        if ( deliveryPersonnelServices.createDeliveryPersonnel(redirectAttributes,deliveryPersonnelModel,address,personModel)) {
            return "redirect:/login";
        }
        return "redirect:/deliveryPersonnel/create";
    }

    @GetMapping("/deliveryPersonnel/allDeliveryPersonnel")
    public String allPatients(Model model) {
        var deliveryPersonnel = deliveryPersonnelServices.getAllDeliveryPersonnel(model);
        model.addAttribute("deliveryPersonnel" , deliveryPersonnel);
        return "DeliveryPersonnel/allDeliveryPersonnel";
    }

    @GetMapping("/deliveryPersonnel/updateDeliveryPersonnelDetails{id}")
    public String updateDeliveryPersonnel(@PathVariable("id") int id,DeliveryPersonnelRegistrationModel deliveryPersonnelModel,Address address,PersonRegisterModel personModel) {
        deliveryPersonnelServices.update(id,deliveryPersonnelModel,address,personModel);
        return "redirect:/deliveryPersonnel/allDeliveryPersonnel";
    }

    @GetMapping("/deliveryPersonnel/softDelete{id}")
    public String softDeletePatient(@PathVariable("id") int id) {
        deliveryPersonnelServices.disablePatient(id);
        return "redirect:/deliveryPersonnel/allDeliveryPersonnel";
    }

    @GetMapping("/deliveryPersonnel/seeDeliveryPersonnelDetails/{id}")
    public String details(@PathVariable int id,Model models) {
        var patient = deliveryPersonnelRepositories.findById(id).get();
        models.addAttribute("deliveryPersonnelDetails", patient);
        return "DeliveryPersonnel/deliveryPersonnelDetails";
    }
}
