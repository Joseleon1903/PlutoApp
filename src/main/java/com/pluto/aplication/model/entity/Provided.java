package com.pluto.aplication.model.entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Provided_Tab")
public class Provided implements Serializable{

    private static final long serialVersionUID = 5791169156221909874L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String address;
    private String phone;
    private String email;
    private Boolean isValidEmail;
   
    @OneToMany(mappedBy="provided", fetch=FetchType.LAZY)
    private Set<Items> itemsList;

    public Provided() {
    }

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

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean isIsValidEmail() {
        return this.isValidEmail;
    }

    public void setIsValidEmail(Boolean isValidEmail) {
        this.isValidEmail = isValidEmail;
    }

    public Set<Items> getItemsList() {
        return this.itemsList;
    }

    public void setItemsList(Set<Items> itemsList) {
        this.itemsList = itemsList;
    }

}