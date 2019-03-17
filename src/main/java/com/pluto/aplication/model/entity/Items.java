package com.pluto.aplication.model.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Items_Tab")
public class Items implements Serializable{

    private static final long serialVersionUID = -6629124370667224185L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private Double price;
    @OneToOne
    private ItemType itemType;
    @ManyToOne(fetch=FetchType.LAZY)
    private Provided provided;
    @OneToOne
    public ImagesData image;

    public Items(){}

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public ItemType getItemType() {
        return this.itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public Provided getProvided() {
        return this.provided;
    }

    public void setProvided(Provided provided) {
        this.provided = provided;
    }

    public ImagesData getImage() {
        return this.image;
    }

    public void setImage(ImagesData image) {
        this.image = image;
    }
}