package com.myodoctor.finalproject.repositories;

import com.myodoctor.finalproject.models.Staff;
import org.springframework.data.repository.CrudRepository;

public interface IStaff extends CrudRepository<Staff, Integer> {
}
