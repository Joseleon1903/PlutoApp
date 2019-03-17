package com.pluto.aplication.repository;

import com.pluto.aplication.model.entity.ShoppingStore;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jleon on 12/12/2018.
 */
@org.springframework.stereotype.Repository
public interface ShoppingStoreRepository extends CrudRepository<ShoppingStore, Long>{

}