package com.pluto.aplication.model.dto.form;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by jose eduardo on 3/25/2020.
 */
@Data
@Component
public class TaskViewFormData {

    private Long id;

    private String taskName;

    private String taskDescription;

    private boolean done;

    private String type;

    private int status;

    private String priority;

    private String statement;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    private String note;

}
