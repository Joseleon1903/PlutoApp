package com.pluto.aplication.model.entity;

import lombok.Data;

import java.io.Serializable;

import javax.persistence.*;

@Data
@Entity
@Table(name="Profile_Tab")
public class Profile implements Serializable{

    private static final long serialVersionUID = -8703912039452538788L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    public String firstName;
    public String lastName;
    public String email;
    public String mobilePhone;
    @OneToOne
    public ImagesData image;

    public Profile(){ }

    public Profile(long id,String firstName,String lastName,String email,String mobilePhone){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobilePhone = mobilePhone;
    }
    
}
