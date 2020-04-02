package com.pluto.aplication.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by jose eduardo on 3/25/2020.
 */
@Data
@Entity
public class Comment {

    @Id
    @SequenceGenerator(name = "id_seq", sequenceName = "comment_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq")
    private Long id;

    private Long userId;

    private String message;

    private String userName;

    private String profileImageUserUri;

    private Date sendDate;


}
