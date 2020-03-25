package com.pluto.aplication.repository;

import com.pluto.aplication.model.entity.Statement;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jose eduardo on 3/25/2020.
 */
public interface StatementRepository extends CrudRepository<Statement, Long> {

    Statement findByValue(String value);
}
