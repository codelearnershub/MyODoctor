package com.myodoctor.finalproject.repositories;

import com.myodoctor.finalproject.models.Address;
import com.myodoctor.finalproject.models.Route;
import org.springframework.data.repository.CrudRepository;

public interface IRouteRepositories extends CrudRepository<Route, Integer> {
   Route findByRoute(String route);
}
