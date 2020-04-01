package com.pluto.aplication.mapping;

import com.pluto.aplication.model.dto.form.ProjectFormDTO;
import com.pluto.aplication.model.dto.form.TaskFormData;
import com.pluto.aplication.model.dto.form.TaskViewFormData;
import com.pluto.aplication.model.entity.*;

import java.util.Date;

/**
 * Created by jose eduardo on 3/23/2020.
 */
public class TaskMapping {

    private TaskMapping(){}

    public static Task convertToFormDto(TaskFormData taskFormData){

        Task entity = new Task();

        entity.setTaskTittle(taskFormData.getTittle());
        entity.setTaskDetail(taskFormData.getTaskDetail());
        entity.setStartDate(taskFormData.getStartDate());
        entity.setEndDate(taskFormData.getEndDate());
        entity.setNote(taskFormData.getNote());
        entity.setType(taskFormData.getType());
        entity.setPriority(new Priority(taskFormData.getPriority()));
        entity.setIteration(new Iteration(taskFormData.getIterationName()));
        entity.setStatus(0);
        entity.setDone(false);
        entity.setStatement(new Statement(2, "New"));
        return entity;
    }

    public static TaskViewFormData convertEntityToDto(Task entity){

        TaskViewFormData dto = new TaskViewFormData();

        dto.setId(entity.getId());
        dto.setTaskName(entity.getTaskTittle());
        dto.setTaskDescription(entity.getTaskDetail());
        dto.setDone(entity.isDone());
        dto.setPriority(entity.getPriority().getValue());
        dto.setType(entity.getType());
        dto.setStatus(entity.getStatus());
        dto.setStatement(entity.getStatement().getValue());
        dto.setStartDate(entity.getStartDate());
        dto.setEndDate(entity.getEndDate());
        if(entity.getNote() != null){
            dto.setNote(entity.getNote());
        }

        return dto;
    }



}
