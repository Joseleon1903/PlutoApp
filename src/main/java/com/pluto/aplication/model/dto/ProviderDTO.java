package com.pluto.aplication.model.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class ProviderDTO{

    private long id;
    private String name;

    public ProviderDTO(){}

}