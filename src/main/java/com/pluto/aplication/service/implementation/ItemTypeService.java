package com.pluto.aplication.service.implementation;

import java.util.List;
import com.pluto.aplication.model.entity.ItemType;
import com.pluto.aplication.repository.ItemTypeRepository;
import com.pluto.aplication.service.interfaces.ItemTypeInterfaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ItemTypeService implements ItemTypeInterfaces {

    @Autowired
    private ItemTypeRepository itemTypeRepository;

    @Override
	public List<ItemType> findAll() {
		return itemTypeRepository.findAll();
	}

    @Override
    public ItemType save(ItemType itenType) {
        return itemTypeRepository.save(itenType);
    }

    @Override
    public ItemType findById(long id) {
        return itemTypeRepository.findById(id);
    }

    @Override
    public Page<ItemType> findAllWithPagination(Pageable pageable) {
		return itemTypeRepository.findAll(pageable);
	}

    @Override
    public List<ItemType> findAllActiveType() {
        return itemTypeRepository.findByStateIsTrue();
    }

    @Override
    public ItemType findByName(String name) {
        return itemTypeRepository.findByName(name);
    }
    
}