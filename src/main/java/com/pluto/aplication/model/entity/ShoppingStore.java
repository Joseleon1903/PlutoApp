package com.pluto.aplication.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Shopping_Store_Tab")
public class ShoppingStore implements Serializable{

    private static final long serialVersionUID = -7712784893301970401L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToMany(cascade = { CascadeType.ALL })
    Set<Items> itemsShoppingList = new HashSet<>();

    private Date update;

    private boolean status;

}