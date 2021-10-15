package com.myodoctor.finalproject.repositories;

import com.myodoctor.finalproject.models.Address;
import com.myodoctor.finalproject.models.OrderItem;
import org.springframework.data.repository.CrudRepository;

public interface IOrderItem extends CrudRepository<OrderItem, Integer> {
}
