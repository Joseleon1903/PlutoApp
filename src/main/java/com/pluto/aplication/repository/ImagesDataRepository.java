package com.pluto.aplication.repository;

import com.pluto.aplication.model.entity.ImagesData;
import org.springframework.data.repository.CrudRepository;

public interface ImagesDataRepository extends CrudRepository<ImagesData,Long >{

    ImagesData findByName(String name);

}
