package com.pluto.aplication.model.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * Created by jose eduardo on 3/24/2020.
 */
@Component
@Data
public class SummaryData {

    private Long taskId;

    private Long iterationId;

    private String taskTittle;

    private String taskDetail;

    private String priority;

    private String type;

    private int Status;

    private boolean isDone;

    private String Note;

}
