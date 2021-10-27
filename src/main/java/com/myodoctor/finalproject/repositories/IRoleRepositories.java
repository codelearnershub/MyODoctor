package com.myodoctor.finalproject.repositories;

import com.myodoctor.finalproject.models.Address;
import com.myodoctor.finalproject.models.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IRoleRepositories extends CrudRepository<Role, Integer> {
    Optional<Role> findByName(String name);
    boolean existsByName(String name);
}
