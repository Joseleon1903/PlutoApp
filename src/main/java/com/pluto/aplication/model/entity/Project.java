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
public class Project {

    @Id
    @SequenceGenerator(name = "id_seq", sequenceName = "project_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq")
    private long id;

    private String name;

    private String description;

    private Date creationDate;

    private boolean active;

    @OneToOne
    public ImagesData image;

    public Project(){}

}
