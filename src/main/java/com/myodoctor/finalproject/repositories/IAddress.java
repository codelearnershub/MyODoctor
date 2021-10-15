package com.myodoctor.finalproject.repositories;

import com.myodoctor.finalproject.models.Address;
import org.springframework.data.repository.CrudRepository;

public interface IAddress extends CrudRepository<Address , Integer> {
}
