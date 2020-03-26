package com.pluto.aplication.model.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by jose eduardo on 3/26/2020.
 */
@Component
@Data
public class AttachmentData {

    private Long id;

    private String fileName;

    private String fileDetail;

    private String documentType;

    private String userName;

    private Date uploadDate;

    private String downloadUri;

    private String viewUri;




}
