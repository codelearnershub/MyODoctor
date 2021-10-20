package com.myodoctor.finalproject.repositories;

import com.myodoctor.finalproject.models.Address;
import org.springframework.data.repository.CrudRepository;

public interface IOrderRepositories extends CrudRepository<Order, Integer> {
}
