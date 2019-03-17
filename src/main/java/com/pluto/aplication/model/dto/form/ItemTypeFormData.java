package com.pluto.aplication.model.dto.form;

import javax.validation.constraints.NotBlank;
import org.springframework.stereotype.Component;
import lombok.Data;

@Data
@Component
public class ItemTypeFormData{

    @NotBlank
    private String code;

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    public ItemTypeFormData() {
    }

    public ItemTypeFormData(String code,String name,String description){
        this.code = code;
        this.name = name;
        this.description = description;
    }

}