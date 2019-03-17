package com.pluto.aplication.model.dto.form;

import org.springframework.stereotype.Component;
import lombok.Data;

@Data
@Component
public class ItemFilterFormData{

    private String name;
    private String minPrice;
    private String maxPrice;

    public ItemFilterFormData(){}


}