package com.myodoctor.finalproject.repositories;

import com.myodoctor.finalproject.models.Address;
import com.myodoctor.finalproject.models.Records;
import org.springframework.data.repository.CrudRepository;

public interface IRecords extends CrudRepository<Records, Integer> {
}
