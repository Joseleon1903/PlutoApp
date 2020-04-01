package com.pluto.aplication.repository;

import com.pluto.aplication.model.entity.EmailTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface EmailTemplateRepository extends CrudRepository< EmailTemplate, Long>{

    @Query("select e from EmailTemplate e where e.code like ?1")
    EmailTemplate findByCode(String code);

    @Query("select e from EmailTemplate e")
    List<EmailTemplate> findAll();

}