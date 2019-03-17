package com.pluto.aplication.service.interfaces;

import java.util.List;
import com.pluto.aplication.model.entity.ItemType;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

public interface ItemTypeInterfaces {

    ItemType findById(long id);

    ItemType findByName(String name);

    List<ItemType> findAll();

    List<ItemType> findAllActiveType();

    ItemType save(ItemType itenType);

    Page<ItemType> findAllWithPagination(Pageable pageable);

}
