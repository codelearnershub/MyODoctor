package com.myodoctor.finalproject.repositories;

import com.myodoctor.finalproject.models.Address;
import com.myodoctor.finalproject.models.Subscription;
import org.springframework.data.repository.CrudRepository;

public interface ISubscription extends CrudRepository<Subscription, Integer> {
}
