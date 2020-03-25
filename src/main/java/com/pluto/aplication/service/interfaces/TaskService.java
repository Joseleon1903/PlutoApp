package com.pluto.aplication.service.interfaces;

import com.pluto.aplication.model.entity.Task;

import java.util.List;

/**
 * Created by jose eduardo on 3/23/2020.
 */
public interface TaskService {

    Task created(long projectId, long iterationId, Task task);

    Task findById(Long id);

    List<Task> findAll();

    Task update(Task task);

}
