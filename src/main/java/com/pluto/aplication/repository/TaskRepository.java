package com.pluto.aplication.repository;

import com.pluto.aplication.model.entity.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by jose eduardo on 3/23/2020.
 */
public interface TaskRepository extends PagingAndSortingRepository<Task, Long> {

    @Query(value = "SELECT nextval('task_id_seq')", nativeQuery = true)
    Long getNextSeriesId();

    List<Task> findByIterationName(String name);

    Page<Task> findByIterationName(String name , Pageable pageable);

    List<Task> findByIterationId(Long id);

    Page<Task> findAll(Pageable pageable);

    @Query(value = "SELECT * FROM task WHERE task_tittle = ?1",
            countQuery = "SELECT count(*) FROM task WHERE task_tittle = ?1",
            nativeQuery = true)
    Page<Task> findByTaskTittle(String tittle , Pageable pageable);

}
