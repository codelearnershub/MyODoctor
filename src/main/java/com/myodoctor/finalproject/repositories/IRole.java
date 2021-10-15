package com.myodoctor.finalproject.repositories;

import com.myodoctor.finalproject.models.Address;
import com.myodoctor.finalproject.models.Role;
import org.springframework.data.repository.CrudRepository;

public interface IRole extends CrudRepository<Role, Integer> {
}
