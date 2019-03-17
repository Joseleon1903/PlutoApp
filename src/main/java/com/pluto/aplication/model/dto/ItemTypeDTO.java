package com.pluto.aplication.model.dto;

import java.util.Date;
import org.springframework.stereotype.Component;
import lombok.Data;

/**
 * Created by Jose Eduardo on 6/22/2018.
 */
@Data
@Component
public class ItemTypeDTO{

    private long id;
    private String name;
    private String description;
    private Date creationDate;
    private boolean state;

    public ItemTypeDTO(){}
    
}