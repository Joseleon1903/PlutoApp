package com.pluto.aplication.mapping;

import com.pluto.aplication.model.dto.form.ProjectFormDTO;
import com.pluto.aplication.model.dto.form.TaskFormData;
import com.pluto.aplication.model.entity.Project;
import com.pluto.aplication.model.entity.Task;

import java.util.Date;

/**
 * Created by jose eduardo on 3/23/2020.
 */
public class TaskMapping {

    public static Task convertToFormDto(TaskFormData taskFormData){

        Task entity = new Task();

        entity.setTaskTittle(taskFormData.getTittle());
        entity.setTaskDetail(taskFormData.getTaskDetail());
        entity.setStartDate(taskFormData.getStartDate());
        entity.setEndDate(taskFormData.getEndDate());
        entity.setNote(taskFormData.getNote());
        entity.setType(taskFormData.getType());


        return entity;
    }



}
