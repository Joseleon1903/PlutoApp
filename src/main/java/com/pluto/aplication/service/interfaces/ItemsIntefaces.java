package com.pluto.aplication.service.interfaces;

import java.util.List;
import com.pluto.aplication.model.entity.Items;

public interface ItemsIntefaces{

    Items save(Items items);

    Items findbyId(long id);

    List<Items> findAll();

    List<Items> findFilterParam(String name, String minPrice, String maxPrice); 

    List<Items> findFilterParamCategory(String name, String minPrice, String maxPrice, String Category); 

    List<Items> findByProviderName(String name); 

}