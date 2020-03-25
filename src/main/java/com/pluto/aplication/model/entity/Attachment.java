package com.pluto.aplication.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by jose eduardo on 3/25/2020.
 */
@Data
@Entity
public class Attachment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileName;

    private String fileDetail;

    private String documentType;

    private String UserName;

    private Date uploadDate;

    private String downloadUri;

    private String viewUri;


}
