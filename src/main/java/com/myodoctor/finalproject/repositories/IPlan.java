package com.myodoctor.finalproject.repositories;

import com.myodoctor.finalproject.models.Plan;
import org.springframework.data.repository.CrudRepository;

public interface IPlan extends CrudRepository<Plan, Integer> {
}
