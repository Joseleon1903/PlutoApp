package com.pluto.aplication.service.implementation;

import java.util.List;
import com.pluto.aplication.constant.UtilityAplication;
import com.pluto.aplication.model.entity.Items;
import com.pluto.aplication.repository.ItemsRepository;
import com.pluto.aplication.service.interfaces.ItemsIntefaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ItemsServiceImpl implements ItemsIntefaces {

    @Autowired
    private ItemsRepository itemsRepository;

    @Override
    public Items save(Items items) {
        return itemsRepository.save(items);
    }

    @Override
    public List<Items> findAll() {
		return itemsRepository.findAll();
	}

    @Override
    public List<Items> findFilterParam(String name, String minPrice, String maxPrice) {
        double maxP = Double.parseDouble(maxPrice);
        double minP = Double.parseDouble(minPrice);
        Pageable page = UtilityAplication.createPageableDefault();
        Page<Items> listresult = itemsRepository.findFilterParam(page, name, minP, maxP); 
        return listresult.getContent();
    }

    @Override
    public List<Items> findByProviderName(String name) {
        Pageable page = UtilityAplication.createPageableDefault();
		return itemsRepository.findByProviderName(page,name).getContent();
    }

    @Override
    public List<Items> findFilterParamCategory(String name, String minPrice, String maxPrice, String Category) {
        double maxP = Double.parseDouble(maxPrice);
        double minP = Double.parseDouble(minPrice);
        Pageable page = UtilityAplication.createPageableDefault();
        Page<Items> listresult = itemsRepository.findFilterParamCategory(page, name, minP, maxP,Category); 
        return listresult.getContent();
    }

    @Override
    public Items findbyId(long id) {
        return itemsRepository.findById(id).get();
    }

}