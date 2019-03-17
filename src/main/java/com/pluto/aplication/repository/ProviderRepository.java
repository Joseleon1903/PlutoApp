package com.pluto.aplication.repository;

import com.pluto.aplication.model.entity.Provided;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProviderRepository extends PagingAndSortingRepository<Provided, Long>, CrudRepository<Provided, Long> {

    @Query("from Provided p")
    Page<Provided> findAll(Pageable pageable);

    Page<Provided> findByNameContainingIgnoreCase(String name, Pageable pageable);

    Provided findById(long id);
}