package com.myodoctor.finalproject.repositories;

import com.myodoctor.finalproject.models.Person;
import org.springframework.data.repository.CrudRepository;

public interface IPersonRepositories extends CrudRepository<Person, Integer> {
    Person findByUsername(String username);
}
