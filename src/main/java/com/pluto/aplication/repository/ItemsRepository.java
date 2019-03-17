package com.pluto.aplication.repository;

import java.util.List;
import com.pluto.aplication.model.entity.Items;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ItemsRepository extends CrudRepository<Items, Long>{

    List<Items> findAll();

    @Query("from Items i where (lower(i.name) like lower(:name) or lower(i.description) like lower(:name)) and i.price  BETWEEN :minPrice and :maxPrice")
    Page<Items> findFilterParam(Pageable page, String name, Double minPrice, Double maxPrice);

    @Query("from Items i where i.itemType.name like :name")
    Page<Items> findByProviderName(Pageable page,String name); 

    @Query("from Items i where (lower(i.name) like lower(:name) or lower(i.description) like lower(:name)) and i.itemType.name like :itemType and i.price  BETWEEN :minPrice and :maxPrice")
    Page<Items> findFilterParamCategory(Pageable page, String name, Double minPrice, Double maxPrice, String itemType);

    
}
