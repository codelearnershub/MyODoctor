package com.myodoctor.finalproject.services.Interfaces;

import com.myodoctor.finalproject.models.Address;
import com.myodoctor.finalproject.models.RegisterModel.PersonRegisterModel;
import com.myodoctor.finalproject.models.Staff;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface IStaffServices {
    Staff createStaff(Address address, PersonRegisterModel personModel, RedirectAttributes redirectAttributes, String role);
}
