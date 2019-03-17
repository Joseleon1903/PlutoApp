package com.pluto.aplication.model.dto.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import org.springframework.stereotype.Component;
import lombok.Data;

@Data
@Component
public class ItemFormData{

    @NotBlank
    private String name;
    private String description;
    @PositiveOrZero
    @NotNull
    private Double price;
    private long itemTypeId;
    private long provideId;
    private Long imageId;
    private String pictureUrl = "http://localhost:8085/api/file/view/image/unknow-profile.png";

    public ItemFormData() {}

}