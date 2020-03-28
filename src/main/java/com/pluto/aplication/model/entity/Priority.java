package com.pluto.aplication.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by jose eduardo on 3/16/2020.
 */
@Data
@Entity
public class Priority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String value;

    public Priority(){}

    public Priority(String value) {
        this.value = value;
    }
}
