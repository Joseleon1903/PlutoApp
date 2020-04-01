package com.pluto.aplication.repository;

import com.pluto.aplication.model.entity.Iteration;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by jose eduardo on 3/21/2020.
 */
public interface IterationRepository extends CrudRepository<Iteration, Long> {

    List<Iteration> findByProjectIdOrderById(long projecId);

    Iteration findByName(String name);

}
