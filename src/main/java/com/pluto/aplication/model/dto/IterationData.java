package com.pluto.aplication.model.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import java.util.Date;

/**
 * Created by jose eduardo on 3/26/2020.
 */
@Component
@Data
public class IterationData {

    private Long id;

    private String name;

    private String description;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date iniDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    private long dayRemain;

    private int totalTask;

    private int completeTask;

    private int pendingTask;

}
