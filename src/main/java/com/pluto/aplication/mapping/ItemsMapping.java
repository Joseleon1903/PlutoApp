package com.pluto.aplication.mapping;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import com.pluto.aplication.model.dto.ItemDTO;
import com.pluto.aplication.model.entity.Items;

/**
 * Created by Jose Eduardo on 6/16/2018.
 */
public class ItemsMapping {

    private ItemsMapping(){}

    public static List<ItemDTO> getItemsList(List<Items> listEntity){
        List<ItemDTO> listOut = new ArrayList<>();
        listEntity.forEach((i )->{
            ItemDTO dto = new ItemDTO();
            dto.setId(i.getId());
            dto.setName(i.getName());
            dto.setDescription(i.getDescription());
            dto.setPrice(i.getPrice());
            dto.setItemType(i.getItemType().getName());
            if(i.getImage() != null){
                dto.setPictureUrl(i.getImage().getFileViewUri());
            }
            listOut.add(dto);
        });
        return listOut;
    }

    public static Set<ItemDTO> getItemsList(Set<Items> listEntity){
        Set<ItemDTO> listOut = new HashSet<>();
        listEntity.forEach((i )->{
            ItemDTO dto = new ItemDTO();
            dto.setId(i.getId());
            dto.setName(i.getName());
            dto.setDescription(i.getDescription());
            dto.setPrice(i.getPrice());
            dto.setItemType(i.getItemType().getName());
            if(i.getImage() != null){
                dto.setPictureUrl(i.getImage().getFileViewUri());
            }
            listOut.add(dto);
        });
        return listOut;
    }

    public static ItemDTO getItemsFromEntity(Items entity){
        ItemDTO itemOut = new ItemDTO();
        itemOut.setId(entity.getId());
        itemOut.setName(entity.getName());
        itemOut.setDescription(entity.getDescription());
        itemOut.setPrice(entity.getPrice());
        itemOut.setItemType(entity.getItemType().getName());
        itemOut.setPictureUrl(entity.getImage().getFileViewUri());
        return itemOut;
    }
    
}