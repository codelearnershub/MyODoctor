package com.myodoctor.finalproject.repositories;

import com.myodoctor.finalproject.models.Patient;
import org.springframework.data.repository.CrudRepository;

public interface IPatientRepositories extends CrudRepository<Patient, Integer> {
}
