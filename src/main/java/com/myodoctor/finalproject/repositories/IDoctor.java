package com.myodoctor.finalproject.repositories;

import com.myodoctor.finalproject.models.Doctor;
import org.springframework.data.repository.CrudRepository;

public interface IDoctor extends CrudRepository<Doctor, Integer> {
}
