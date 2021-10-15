package com.myodoctor.finalproject.repositories;

import com.myodoctor.finalproject.models.Person;
import org.springframework.data.repository.CrudRepository;

public interface IPerson extends CrudRepository<Person, Integer> {
}
