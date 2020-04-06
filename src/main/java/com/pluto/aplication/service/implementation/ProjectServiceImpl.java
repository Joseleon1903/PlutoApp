package com.pluto.aplication.service.implementation;

import com.pluto.aplication.controller.project.ProjectDetailPageController;
import com.pluto.aplication.model.entity.Project;
import com.pluto.aplication.repository.ProjectRepository;
import com.pluto.aplication.service.interfaces.ProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jose eduardo on 3/20/2020.
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    Logger logger = LoggerFactory.getLogger(ProjectServiceImpl.class);

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Project save(Project project) {
        long id = projectRepository.getNextSeriesId();
        project.setId(id);
        return projectRepository.save(project);
    }

    @Override
    public Project findById(Long id) {
        return projectRepository.findById(id).get();
    }

    @Override
    public List<Project> findAllProjects() {
        List<Project> list =  new ArrayList<>();
        projectRepository.findAll().forEach(item ->{
            list.add(item);
        });
        return list;
    }

    @Override
    public Project findByName(String projectName) {
        Project project = projectRepository.findByName(projectName);
        if(project == null){
            try{
                long id = Long.parseLong(projectName);
                project = projectRepository.findById(id).get();
            }catch (NumberFormatException ex){
                logger.info("Format number exception");
                logger.info("Exception : "+ex.getStackTrace());
            }
        }
        return project;
    }
}
