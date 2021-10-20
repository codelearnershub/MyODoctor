package com.myodoctor.finalproject.services.Implementations;


import com.myodoctor.finalproject.models.DeliveryPersonnel;
import com.myodoctor.finalproject.models.Patient;
import com.myodoctor.finalproject.models.Person;
import com.myodoctor.finalproject.models.RegisterModel.DeliveryPersonnelRegistrationModel;
import com.myodoctor.finalproject.models.RegisterModel.PatientRegistrationModel;
import com.myodoctor.finalproject.models.RegisterModel.PersonRegisterModel;
import com.myodoctor.finalproject.models.Staff;
import com.myodoctor.finalproject.repositories.IDeliveryPersonnelRepositories;
import com.myodoctor.finalproject.repositories.IStaffRepositories;
import com.myodoctor.finalproject.services.Interfaces.IPersonServices;
import com.myodoctor.finalproject.services.Interfaces.IStaffServices;
import org.springframework.beans.factory.annotation.Autowired;

public class StaffServices implements IStaffServices {

    StaffServices staffServices;
    IDeliveryPersonnelRepositories deliveryPersonnelRepositories;
    DeliveryPersonnelRegistrationModel deliveryPersonnelModel;
    Staff staff;
    IPersonServices personServices;
    PersonRegisterModel personModel;
    IStaffRepositories staffRepositories;

    public StaffServices(Staff staff,StaffServices staffServices, IDeliveryPersonnelRepositories deliveryPersonnelRepositories, DeliveryPersonnelRegistrationModel deliveryPersonnelModel, IPersonServices personServices, PersonRegisterModel personModel) {
        this.staff = staff;
        this.staffServices = staffServices;
        this.deliveryPersonnelRepositories = deliveryPersonnelRepositories;
        this.deliveryPersonnelModel = deliveryPersonnelModel;
        this.personServices = personServices;
        this.personModel = personModel;
    }

    public boolean createStaff(String role) {
        personServices.createPerson(personModel,role);
        Staff newStaff = new Staff(staff.getPerson(),role);
        staffRepositories.save(newStaff);
        return true;
    }
}