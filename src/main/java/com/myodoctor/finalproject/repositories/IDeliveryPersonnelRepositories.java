package com.myodoctor.finalproject.repositories;

import com.myodoctor.finalproject.models.Address;
import com.myodoctor.finalproject.models.DeliveryPersonnel;
import org.springframework.data.repository.CrudRepository;

public interface IDeliveryPersonnelRepositories extends CrudRepository<DeliveryPersonnel, Integer> {
}
