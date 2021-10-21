package com.myodoctor.finalproject.services.Implementations;


import com.myodoctor.finalproject.models.Address;
import com.myodoctor.finalproject.models.RegisterModel.PersonRegisterModel;
import com.myodoctor.finalproject.models.Staff;
import com.myodoctor.finalproject.models.validations.PersonFormValidations;
import com.myodoctor.finalproject.repositories.IDeliveryPersonnelRepositories;
import com.myodoctor.finalproject.repositories.IStaffRepositories;
import com.myodoctor.finalproject.services.Interfaces.IPersonServices;
import com.myodoctor.finalproject.services.Interfaces.IStaffServices;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public class StaffServices implements IStaffServices {

    StaffServices staffServices;
    PersonFormValidations formValidations;
    IDeliveryPersonnelRepositories deliveryPersonnelRepositories;
    IPersonServices personServices;
    IStaffRepositories staffRepositories;

    public StaffServices(StaffServices staffServices, IDeliveryPersonnelRepositories deliveryPersonnelRepositories, IPersonServices personServices) {
        this.staffServices = staffServices;
        this.deliveryPersonnelRepositories = deliveryPersonnelRepositories;
        this.personServices = personServices;
    }

    public Staff createStaff(Address address, PersonRegisterModel personModel, RedirectAttributes redirectAttributes, String role) {
        Staff newStaff = new Staff();
        if (formValidations.validate(redirectAttributes,personModel)) {
            var newPerson = personServices.createPerson(address,personModel, role);
            newStaff = new Staff(newPerson, role);
            staffRepositories.save(newStaff);
            return newStaff;
        }
        return newStaff;
    }

    public boolean updateStaff(int id, Staff staff) {
//        var presentStaff = staffRepositories.findById(id).get();
//        presentStaff.setPerson(staff.getPerson());
        return true;
    }
}