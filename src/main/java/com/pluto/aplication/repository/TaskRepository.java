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

    @Query(value = "select * from task t join priority pri ON t.priority_id = pri.id " +
            "left join iteration it ON t.iteration_task = it.id " +
            "left join project pro ON it.project_iteration = pro.id " +
            "         where (upper(t.task_tittle) like upper(?1) or " +
            "                           upper(t.task_detail) like upper(?1) or " +
            "                           upper(it.name) like upper(?1)  or  " +
            "                           upper(pro.name) like upper(?1) ) and " +
            "                           upper(t.type) like COALESCE(upper(?2), '%%') and " +
            "                           upper(pri.value) like COALESCE(upper(?3), '%%') and " +
            "                           t.is_done = COALESCE(upper(?4), false)",

            countQuery = "SELECT count(*) from task t join priority pri ON t.priority_id = pri.id " +
                    " left join iteration it ON t.iteration_task = it.id " +
                    " left join project pro ON it.project_iteration = pro.id "+
                    "            where (upper(t.task_tittle) like upper(?1) or " +
                    "                   upper(t.task_detail) like upper(?1) or " +
                    "                   upper(it.name) like upper(?1)  or " +
                    "                   upper(pro.name) like upper(?1) ) and " +
                    "                   upper(t.type) like COALESCE(upper(?2), '%%') and " +
                    "                   upper(pri.value) like COALESCE(upper(?3), '%%') and " +
                    "                   t.is_done = COALESCE(upper(?4), false)",
            nativeQuery = true)
    Page<Task> findByTaskTittle(String tittle, String type, String priority , Boolean done, Pageable pageable);

}
