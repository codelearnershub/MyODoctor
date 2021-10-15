package com.myodoctor.finalproject.repositories;

import com.myodoctor.finalproject.models.Address;
import com.myodoctor.finalproject.models.DeliveryPersonnel;
import org.springframework.data.repository.CrudRepository;

public interface IDeliveryPersonnel extends CrudRepository<DeliveryPersonnel, Integer> {
}
