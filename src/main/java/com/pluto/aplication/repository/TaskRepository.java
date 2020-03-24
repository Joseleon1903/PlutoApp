package com.pluto.aplication.repository;

import com.pluto.aplication.model.entity.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by jose eduardo on 3/23/2020.
 */
public interface TaskRepository extends CrudRepository<Task, Long> {

    List<Task> findByIterationName(String name);

}
