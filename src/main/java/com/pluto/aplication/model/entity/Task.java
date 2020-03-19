package com.pluto.aplication.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by jose eduardo on 3/16/2020.
 */
@Data
//@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String taskTittle;

    private String taskDetail;

    @OneToOne
    private Priority priority;

    private Date startDate;

    private Date endDate;

    private int status;

    private boolean isDone;

    private String note;

    @ManyToOne
    @JoinColumn(name="iteration_task")
    private Iteration iteration;

}
