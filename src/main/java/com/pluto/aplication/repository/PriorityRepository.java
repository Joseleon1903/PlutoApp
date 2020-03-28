package com.pluto.aplication.repository;

import com.pluto.aplication.model.entity.Priority;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jose eduardo on 3/16/2020.
 */
public interface PriorityRepository extends CrudRepository<Priority, Long> {

    Priority findByValue(String value);

}
