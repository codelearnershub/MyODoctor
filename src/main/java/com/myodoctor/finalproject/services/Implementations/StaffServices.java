package com.myodoctor.finalproject.services.Implementations;

import com.myodoctor.finalproject.models.Address;
import com.myodoctor.finalproject.models.RegisterModel.PersonRegisterModel;
import com.myodoctor.finalproject.models.Role;
import com.myodoctor.finalproject.models.Staff;
import com.myodoctor.finalproject.repositories.IDeliveryPersonnelRepositories;
import com.myodoctor.finalproject.repositories.IRoleRepositories;
import com.myodoctor.finalproject.repositories.IStaffRepositories;
import com.myodoctor.finalproject.services.Interfaces.IPersonService;
import com.myodoctor.finalproject.services.Interfaces.IStaffServices;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Service
public class StaffServices implements IStaffServices {

    final IRoleRepositories roleRepositories;
    final IDeliveryPersonnelRepositories deliveryPersonnelRepositories;
    final IPersonService personServices;
    final IStaffRepositories staffRepositories;

    public StaffServices(IRoleRepositories roleRepositories, IDeliveryPersonnelRepositories deliveryPersonnelRepositories, IPersonService personServices, IStaffRepositories staffRepositories) {
        this.roleRepositories = roleRepositories;
        this.deliveryPersonnelRepositories = deliveryPersonnelRepositories;
        this.personServices = personServices;
        this.staffRepositories = staffRepositories;
    }

    public Staff createStaff(Address address, PersonRegisterModel personModel, RedirectAttributes redirectAttributes, String role) {
        if (roleRepositories.existsByName(role)) {
            var newPerson = personServices.createPerson(redirectAttributes,address, personModel, role,true);
            Staff newStaff = new Staff(newPerson, role);
            staffRepositories.save(newStaff);
            return newStaff;
        } else {
            Role newRole = new Role(role);
            roleRepositories.save(newRole);
            var newPerson = personServices.createPerson(redirectAttributes,address, personModel, role,true);
            Staff newStaff = new Staff(newPerson, role);
            staffRepositories.save(newStaff);
            return newStaff;
        }
    }

    public boolean updateStaff(int id, Staff staff) {
        return true;
    }
}