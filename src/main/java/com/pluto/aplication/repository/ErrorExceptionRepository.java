package com.pluto.aplication.repository;

import java.util.List;
import com.pluto.aplication.model.entity.ErrorException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

@org.springframework.stereotype.Repository
public interface ErrorExceptionRepository extends JpaRepository< ErrorException, Long>, Repository<ErrorException, Long>{

    @Query("select e from ErrorException e where e.status = true")
    List<ErrorException> findAllActive();

    @Query("select e from ErrorException e where e.code like ?1")
    ErrorException findByCode(long code);

}