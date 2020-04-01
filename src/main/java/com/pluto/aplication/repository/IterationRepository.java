package com.pluto.aplication.repository;

import com.pluto.aplication.model.entity.Iteration;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by jose eduardo on 3/21/2020.
 */
public interface IterationRepository extends PagingAndSortingRepository<Iteration, Long> {

    Iteration findByProjectIdAndNameOrderById(long projecId, String name);

    List<Iteration> findByProjectNameOrderById(String name);

    List<Iteration> findByProjectIdOrderById(long projectId);

    Iteration findByName(String name);

}
