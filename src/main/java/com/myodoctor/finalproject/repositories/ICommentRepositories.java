package com.myodoctor.finalproject.repositories;

import com.myodoctor.finalproject.models.Address;
import com.myodoctor.finalproject.models.Comment;
import org.springframework.data.repository.CrudRepository;

public interface ICommentRepositories extends CrudRepository<Comment, Integer> {
}
