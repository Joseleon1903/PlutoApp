package com.pluto.aplication.repository;

import java.util.List;
import com.pluto.aplication.model.entity.ItemType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ItemTypeRepository extends CrudRepository<ItemType, Long>, PagingAndSortingRepository<ItemType, Long> {

    ItemType findById(long id);
    
    ItemType findByName(String name);

    List<ItemType> findAll();

    List<ItemType> findByStateIsTrue();

}