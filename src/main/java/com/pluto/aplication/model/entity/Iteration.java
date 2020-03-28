package com.pluto.aplication.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by jose eduardo on 3/16/2020.
 */
@Data
@Entity
public class Iteration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String description;

    private Date creationDate;

    private Date initDate;

    private Date endDate;

    private boolean active;

    @ManyToOne
    @JoinColumn(name="project_iteration")
    private Project project;

    public Iteration(String name) {
        this.name = name;
    }

    public Iteration() {}
}
