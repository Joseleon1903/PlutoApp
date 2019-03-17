package com.pluto.aplication.model.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Component;
import lombok.Data;

@Data
@Component
public class ShoppingStoreDTO{

    private long id;

    Set<ItemDTO> itemsShoppingList = new HashSet<>();

    private Date update;

    private boolean status;

    private String timePast;

    public ShoppingStoreDTO(){}

    public ShoppingStoreDTO(long id){
        this.id = id;
    }

} 