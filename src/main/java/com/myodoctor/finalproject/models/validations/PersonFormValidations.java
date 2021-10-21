package com.myodoctor.finalproject.models.validations;

import com.myodoctor.finalproject.models.RegisterModel.PersonRegisterModel;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public class PersonFormValidations {
    public boolean validate(RedirectAttributes redirectAttributes,PersonRegisterModel personModel) {
        if (personModel.getFirstName().isEmpty() || personModel.getFirstName() == null) {
            redirectAttributes.addAttribute("userError", "FirstName Must Be Specified");
        } else if (personModel.getLastName().isEmpty() || personModel.getLastName() == null) {
            redirectAttributes.addAttribute("userError", "LastName Must Be Specified");
        } else if (personModel.getMobileNo().isEmpty() || personModel.getMobileNo() == null) {
            redirectAttributes.addAttribute("userError", "Mobile No Must Be Specified");
        } else if (personModel.getEmail().isEmpty() || personModel.getEmail() == null || personModel.getEmail().contains("@") || !personModel.getEmail().contains(".")) {
            redirectAttributes.addAttribute("userError", "Invalid Email");
        } else if (personModel.getGender().isEmpty() || personModel.getGender() == null) {
            redirectAttributes.addAttribute("userError", "Gender Must Be Specified");
        } else if (personModel.getDateOfBirth() == null) {
            redirectAttributes.addAttribute("userError", "Date Cannot Be Empty");
        } else if (personModel.getUsername().isEmpty() || personModel.getUsername() == null) {
            redirectAttributes.addAttribute("userError", "User Name can not be empty or blank.");
        } else if (personModel.getPassword().isEmpty() || personModel.getPassword().isBlank() || personModel.getConfirmPassword() != personModel.getPassword() || personModel.getConfirmPassword().isEmpty() || personModel.getConfirmPassword().isBlank()) {
            redirectAttributes.addAttribute("userError", "Invaild Password");
        }
        return true;
    }
}