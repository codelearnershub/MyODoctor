package com.myodoctor.finalproject.repositories;

import com.myodoctor.finalproject.models.Address;
import com.myodoctor.finalproject.models.Language;
import org.springframework.data.repository.CrudRepository;

public interface ILanguageRepositories extends CrudRepository<Language, Integer> {
}
