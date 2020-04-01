package com.pluto.aplication.model.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * Created by jose eduardo on 3/28/2020.
 */
@Component
@Data
public class ErrorData {

    private Long id;

    private String code;

    private String tittle;

    private String description;

    public ErrorData(Long id, String code, String tittle, String description) {
        this.id = id;
        this.code = code;
        this.tittle = tittle;
        this.description = description;
    }

    public ErrorData() {}
}
