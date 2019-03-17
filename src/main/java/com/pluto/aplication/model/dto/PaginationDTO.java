package com.pluto.aplication.model.dto;

import org.springframework.stereotype.Component;
import lombok.Data;

@Data
@Component
public class PaginationDTO{

    private Integer numberPage;
    private Integer numberRow;

    public PaginationDTO(){}

}