package com.pluto.aplication.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by jose eduardo on 3/25/2020.
 */
@Data
@Entity
public class Attachment {

    @Id
    @SequenceGenerator(name = "id_seq", sequenceName = "attachment_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq")
    private Long id;

    private String fileName;

    private String fileDetail;

    private String documentType;

    private String userName;

    private Date uploadDate;

    private String downloadUri;

    private String viewUri;


}
