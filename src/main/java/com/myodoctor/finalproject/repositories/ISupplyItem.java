package com.myodoctor.finalproject.repositories;

import com.myodoctor.finalproject.models.Address;
import com.myodoctor.finalproject.models.SupplyItem;
import org.springframework.data.repository.CrudRepository;

public interface ISupplyItem extends CrudRepository<SupplyItem, Integer> {
}
