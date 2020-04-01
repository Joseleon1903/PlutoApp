package com.pluto.aplication.repository;

import com.pluto.aplication.model.entity.Comment;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jose eduardo on 3/26/2020.
 */
public interface CommentRepository extends CrudRepository<Comment, Long>{
}
