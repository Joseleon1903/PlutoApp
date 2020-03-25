package com.pluto.aplication.service.implementation;

import com.pluto.aplication.model.entity.Iteration;
import com.pluto.aplication.model.entity.Project;
import com.pluto.aplication.model.entity.Task;
import com.pluto.aplication.repository.IterationRepository;
import com.pluto.aplication.repository.ProjectRepository;
import com.pluto.aplication.repository.TaskRepository;
import com.pluto.aplication.service.interfaces.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jose eduardo on 3/23/2020.
 */
@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private IterationRepository iterationRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task created(long projectId, long iterationId, Task task) {

        Project projectEntity = projectRepository.findById(projectId).get();

        Iteration iterationEntity = iterationRepository.findById(iterationId).get();

        iterationEntity.setProject(projectEntity);

        task.setIteration(iterationEntity);

        return taskRepository.save(task);
    }

    @Override
    public Task findById(Long id) {
        return taskRepository.findById(id).get();
    }

    @Override
    public List<Task> findAll() {
        List<Task> list =  new ArrayList<>();
        taskRepository.findAll().forEach(item ->{
            list.add(item);
        });
        return list;
    }

    @Override
    public Task update(Task task) {
        return taskRepository.save(task);
    }
}
