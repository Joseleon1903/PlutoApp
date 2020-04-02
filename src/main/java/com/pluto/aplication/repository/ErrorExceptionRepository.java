package com.pluto.aplication.repository;

import java.util.List;
import com.pluto.aplication.model.entity.ErrorException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface ErrorExceptionRepository extends CrudRepository< ErrorException, Long>{

    @Query("select e from ErrorException e where e.status = true")
    List<ErrorException> findAllActive();

    ErrorException findByCode(long code);

}