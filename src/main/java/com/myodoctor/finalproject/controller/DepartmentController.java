package com.myodoctor.finalproject.controller;

import com.myodoctor.finalproject.repositories.IDepartmentRepositories;
import com.myodoctor.finalproject.services.Implementations.DepartmentServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DepartmentController {
    final IDepartmentRepositories departmentRepositories;
    final DepartmentServices departmentServices;


    public DepartmentController(IDepartmentRepositories departmentRepositories, DepartmentServices departmentServices) {
        this.departmentRepositories = departmentRepositories;

        this.departmentServices = departmentServices;
    }

    @GetMapping("/department/createDepartment")
    public String createDepartment() {
        return "Department/createDepartment";
    }

    @PostMapping("/department/saveDepartment")
    public String saveDepartment(String name) {
        departmentServices.createDepartment(name);
        return "redirect:/department/allDepartment";
    }

    @GetMapping("department/deleteDepartment/{id}")
    public String deleteDepartment(@PathVariable("id") int id) {
        departmentServices.deleteDepartment(id);
        return "redirect:/department/allDepartment";
    }

    @GetMapping("department/allDepartment")
    public String allDepartment(Model model) {
        model.addAttribute("department",departmentRepositories.findAll());
        return "Department/allDepartment";
    }
}
