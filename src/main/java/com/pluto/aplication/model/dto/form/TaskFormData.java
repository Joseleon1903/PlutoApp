package com.pluto.aplication.model.dto.form;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by jose eduardo on 3/22/2020.
 */
@Data
@Component
public class TaskFormData {

    public Long projectId;

    public String iterationName;

    private String tittle;

    private String taskDetail;

    private String priority;

    private Date startDate;

    private Date endDate;

    private String type;

    private boolean isDone;

    private String note;





}
