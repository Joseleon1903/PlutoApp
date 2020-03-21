package com.pluto.aplication.service.implementation;

import com.pluto.aplication.model.entity.Iteration;
import com.pluto.aplication.model.entity.Project;
import com.pluto.aplication.repository.IterationRepository;
import com.pluto.aplication.repository.ProjectRepository;
import com.pluto.aplication.service.interfaces.IterationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jose eduardo on 3/21/2020.
 */
@Service
public class IterationServiceImpl implements IterationService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private IterationRepository iterationRepository;

    @Override
    public Iteration save(Long projectId, Iteration iteration) {

        Project project = projectRepository.findById(projectId).get();

        iteration.setProject(project);

        return iterationRepository.save(iteration);
    }

    @Override
    public List<Iteration> findAll() {
        List<Iteration> list = new ArrayList<>();
        iterationRepository.findAll().forEach(index ->{
            list.add(index);
        });
        return list;
    }

    @Override
    public List<Iteration> findByProjectId(Long projectId) {
        return iterationRepository.findByProjectIdOrderById(projectId);
    }
}
