package com.pluto.aplication.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by jose eduardo on 3/25/2020.
 */
@Data
@Entity
public class Statement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String value;

    public Statement(){}

    public Statement(int id, String value){
        this.id = id;
        this.value =value;
    }


}
