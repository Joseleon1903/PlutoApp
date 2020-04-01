package com.pluto.aplication.repository;

import com.pluto.aplication.model.entity.Priority;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jose eduardo on 3/16/2020.
 */
public interface PriorityRepository extends CrudRepository<Priority, Long> {

    @Query(value = "SELECT nextval('priority_seq')", nativeQuery = true)
    Long getNextSeriesId();

    Priority findByValue(String value);

}
