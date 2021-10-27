package com.myodoctor.finalproject.controller;

import com.myodoctor.finalproject.models.Role;
import com.myodoctor.finalproject.repositories.IRoleRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RoleController {

    final IRoleRepositories roleRepositories;

    public RoleController(IRoleRepositories roleRepositories) {
        this.roleRepositories = roleRepositories;
    }

    @GetMapping("/role/createRole")
    public  String createRole() {
        return "Role/CreateRole";
    }
    @PostMapping("/roles/saveRole")
    public String roleCreation(String roleName) {
        Role role = new Role(roleName);
        roleRepositories.save(role);
       return "redirect:/role/allRoles";
    }
    @GetMapping("role/allRoles")
    public String allRole(Model model) {
        model.addAttribute("role", roleRepositories.findAll());
        return "Role/allRoles";
    }
}
