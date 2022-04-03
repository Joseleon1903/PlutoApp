package com.pluto.aplication.model.entity;

import lombok.Data;

import java.io.Serializable;

import javax.persistence.*;

@Data
@Entity
public class EmailTemplate implements Serializable{

    private static final long serialVersionUID = 2936373077564813096L;

    @Id
    @SequenceGenerator(name = "id_email_template_seq", sequenceName = "email_template_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_email_template_seq")
    private long id;
    private String code;
    private String header;
    private String content;

    public EmailTemplate(){}


}
