package com.myodoctor.finalproject.services.Implementations;

import com.myodoctor.finalproject.models.Department;
import com.myodoctor.finalproject.repositories.IDepartmentRepositories;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServices {

    final IDepartmentRepositories departmentRepositories;

    public DepartmentServices(IDepartmentRepositories departmentRepositories) {
        this.departmentRepositories = departmentRepositories;
    }

    public Department createDepartment(String name) {
        Department department = new Department(name);
        departmentRepositories.save(department);
        return department;
    }

    public boolean deleteDepartment(int id) {
        departmentRepositories.delete(departmentRepositories.findById(id));
        return true;
    }
}