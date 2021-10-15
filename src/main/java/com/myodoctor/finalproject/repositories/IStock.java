package com.myodoctor.finalproject.repositories;

import com.myodoctor.finalproject.models.Address;
import com.myodoctor.finalproject.models.Stock;
import org.springframework.data.repository.CrudRepository;

public interface IStock extends CrudRepository<Stock, String> {
}
