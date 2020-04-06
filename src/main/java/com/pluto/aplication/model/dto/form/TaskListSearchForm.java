package com.pluto.aplication.model.dto.form;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * Created by jose eduardo on 4/6/2020.
 */
@Data
@Component
public class TaskListSearchForm {

    private String content;

    private String showEntry;

    private String type;

    private String priority;

    private String done;

    public TaskListSearchForm(){}
}
