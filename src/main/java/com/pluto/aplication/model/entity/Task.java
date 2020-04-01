package com.pluto.aplication.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by jose eduardo on 3/16/2020.
 */
@Data
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String taskTittle;

    private String taskDetail;

    @OneToOne
    private Priority priority;

    @OneToOne
    private Statement statement;

    private Date creationDate;

    private Date startDate;

    private Date endDate;

    private String type;

    private int status;

    private boolean isDone;

    private String note;

    @ManyToOne
    @JoinColumn(name="iteration_task")
    private Iteration iteration;

    @OneToMany
    List<Comment> commnets = new ArrayList<>();

    @OneToMany
    List<Attachment> attachments = new ArrayList<>();

}
