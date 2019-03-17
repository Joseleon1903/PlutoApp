package com.pluto.aplication.model.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="Item_Type_Tab")
public class ItemType implements Serializable{

    private static final long serialVersionUID = 3874734704099961725L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String code;
    private String name;
    private String description;
    private Date creationDate;
    private boolean state;
    

    public ItemType() {
    }

}