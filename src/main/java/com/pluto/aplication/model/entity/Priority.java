package com.pluto.aplication.model.entity;

import lombok.Data;
import javax.persistence.*;

/**
 * Created by jose eduardo on 3/16/2020.
 */
@Data
@Entity
public class Priority {

    @Id
    @SequenceGenerator(name = "id_seq", sequenceName = "priority_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq")
    private long id;

    private String value;

    public Priority(){}

    public Priority(String value) {
        this.value = value;
    }
}
