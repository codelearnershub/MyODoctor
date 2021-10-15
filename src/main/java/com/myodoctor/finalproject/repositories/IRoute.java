package com.myodoctor.finalproject.repositories;

import com.myodoctor.finalproject.models.Address;
import com.myodoctor.finalproject.models.Route;
import org.springframework.data.repository.CrudRepository;

public interface IRoute extends CrudRepository<Route, Integer> {
}
