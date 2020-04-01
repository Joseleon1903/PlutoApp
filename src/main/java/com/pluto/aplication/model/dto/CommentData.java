package com.pluto.aplication.model.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by jose eduardo on 3/26/2020.
 */
@Component
@Data
public class CommentData {

    private Long id;

    private String message;

    private String userName;

    private String profileUrl;

    private Date sendDate;

}
