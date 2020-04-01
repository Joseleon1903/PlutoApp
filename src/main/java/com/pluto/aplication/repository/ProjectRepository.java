package com.pluto.aplication.repository;

import com.pluto.aplication.model.entity.Project;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jose eduardo on 3/20/2020.
 */
public interface ProjectRepository extends CrudRepository<Project, Long> {

    Project findByName(String name);

}
