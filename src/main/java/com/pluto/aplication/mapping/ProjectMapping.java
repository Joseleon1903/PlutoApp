package com.pluto.aplication.mapping;

import com.pluto.aplication.model.dto.form.ProfileFormData;
import com.pluto.aplication.model.dto.form.ProjectFormDTO;
import com.pluto.aplication.model.entity.Project;
import com.pluto.aplication.model.entity.SystemUser;

import java.util.Date;

/**
 * Created by jose eduardo on 3/20/2020.
 */
public class ProjectMapping {

    private ProjectMapping(){}

    public static Project convertToFormDto(ProjectFormDTO projectFormDTO){

        Project entity = new Project();

        entity.setName(projectFormDTO.getName());
        entity.setDescription(projectFormDTO.getDescription());
        entity.setCreationDate(new Date());
        entity.setActive(true);
        return entity;
    }

    public static ProjectFormDTO convertToFormDto(Project entity){

        ProjectFormDTO projectDto = new ProjectFormDTO();

        projectDto.setId(entity.getId());
        projectDto.setName(entity.getName());
        projectDto.setDescription(entity.getDescription());

        return projectDto;
    }
}
