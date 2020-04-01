package com.pluto.aplication.service.interfaces;

import com.pluto.aplication.model.entity.Iteration;

import java.util.List;

/**
 * Created by jose eduardo on 3/21/2020.
 */
public interface IterationService {

    Iteration save(Long projectId , Iteration iteration);

    Iteration findById(Long iterationId);

    Iteration findByName(String name);

    List<Iteration> findAll();

    List<Iteration> findByProjectId(Long projectId);

    List<Iteration> findByProjectName(String projectName);


}
