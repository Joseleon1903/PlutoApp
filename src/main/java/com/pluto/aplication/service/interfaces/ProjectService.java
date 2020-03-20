package com.pluto.aplication.service.interfaces;

import com.pluto.aplication.model.entity.Project;
import java.util.List;

/**
 * Created by jose eduardo on 3/20/2020.
 */
public interface ProjectService {

    Project save(Project project);

    Project findById(Long id);

    List<Project> findAllProjects();

    Project findByName(String projectName);

}
