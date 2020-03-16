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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String description;

    private Date creationDate;

    @OneToOne
    public ImagesData image;

    Project(){}

}
