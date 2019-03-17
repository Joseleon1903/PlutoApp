package com.pluto.aplication.mapping;

import java.util.ArrayList;
import java.util.List;
import com.pluto.aplication.model.dto.ProviderDTO;
import com.pluto.aplication.model.entity.Provided;
import org.springframework.data.domain.Page;

public class ProviderMapping {

    private ProviderMapping(){}

    public static List<ProviderDTO> getProviderList(Page<Provided> listEntity){
        List<ProviderDTO> listOut = new ArrayList<>();
        listEntity.getContent().forEach((i )->{
            ProviderDTO dto = new ProviderDTO();
            dto.setId(i.getId());
            dto.setName(i.getName());
            listOut.add(dto);
        });
        return listOut;
    }

}