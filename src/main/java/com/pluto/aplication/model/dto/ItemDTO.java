package com.pluto.aplication.model.dto;

import org.springframework.stereotype.Component;
import lombok.Data;

/**
 * Created by Jose Eduardo on 6/22/2018.
 */
@Data
@Component
public class ItemDTO {

    private long id;
    private String name;
    private String description;
    private Double price;
    private String itemType;
    private String pictureUrl;
    private int quantity = 1;

    public ItemDTO(){}

}