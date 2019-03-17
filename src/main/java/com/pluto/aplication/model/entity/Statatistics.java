package com.pluto.aplication.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "statatistics")
public class Statatistics{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


}