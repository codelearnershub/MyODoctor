package com.myodoctor.finalproject.repositories;

import com.myodoctor.finalproject.models.Department;
import org.springframework.data.repository.CrudRepository;

public interface IDepartment extends CrudRepository<Department, Integer> {
}
