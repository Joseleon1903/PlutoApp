package com.pluto.aplication.model.entity;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

@Entity
@Data
public class Role implements Serializable{

    private static final long serialVersionUID = 172102688145541835L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "roles")
    private Collection<SystemUser> users;

    
}