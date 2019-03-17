package com.pluto.aplication.mapping;

import java.util.ArrayList;
import java.util.List;
import com.pluto.aplication.model.dto.ItemTypeDTO;
import com.pluto.aplication.model.entity.ItemType;

public class ItemTypeMapping {

    private ItemTypeMapping(){}

    /**
     *  param List<ItemType> listType
     * 
     *  return List<String>
     */
    public static List<ItemTypeDTO> getLisCategory(List<ItemType> listType){
        List<ItemTypeDTO> listCat = new ArrayList<>();
        listType.forEach((i )->{
            ItemTypeDTO dto = new ItemTypeDTO();
            dto.setId(i.getId());
            dto.setName(i.getName());
            dto.setDescription(i.getDescription());
            dto.setCreationDate(i.getCreationDate());
            dto.setState(i.isState());
            listCat.add(dto);
        });
        return listCat;
    }

}