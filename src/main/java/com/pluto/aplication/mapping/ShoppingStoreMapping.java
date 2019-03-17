package com.pluto.aplication.mapping;

import java.util.Set;
import com.pluto.aplication.model.dto.ItemDTO;
import com.pluto.aplication.model.dto.ShoppingStoreDTO;
import com.pluto.aplication.model.entity.ShoppingStore;

public class ShoppingStoreMapping{

    private ShoppingStoreMapping(){}

    public static ShoppingStoreDTO convertFromEntity( ShoppingStore entity){
        ShoppingStoreDTO dto = new ShoppingStoreDTO();
        dto.setId(entity.getId());
        dto.setStatus(entity.isStatus());
        dto.setUpdate(entity.getUpdate());
        Set<ItemDTO> listDto= null;
        if(entity.getItemsShoppingList() !=null){
            listDto= ItemsMapping.getItemsList(entity.getItemsShoppingList());
        }
        dto.setItemsShoppingList(listDto);
        return dto;
    }
}