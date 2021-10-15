package com.myodoctor.finalproject.repositories;

import com.myodoctor.finalproject.models.Address;
import com.myodoctor.finalproject.models.Supply;
import org.springframework.data.repository.CrudRepository;

public interface ISupply extends CrudRepository<Supply, Integer> {
}
