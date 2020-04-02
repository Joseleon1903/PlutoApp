package com.pluto.aplication.repository;

import com.pluto.aplication.model.entity.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jose eduardo on 3/20/2020.
 */
public interface ProjectRepository extends CrudRepository<Project, Long> {

    @Query(value = "SELECT nextval('project_id_seq')", nativeQuery = true)
    Long getNextSeriesId();

    Project findByName(String name);

}
