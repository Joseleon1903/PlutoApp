package com.pluto.aplication.service.implementation;

import com.pluto.aplication.model.entity.Statement;
import com.pluto.aplication.repository.StatementRepository;
import com.pluto.aplication.service.interfaces.StatementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jose eduardo on 3/25/2020.
 */
@Service
public class StatementServiceImpl implements StatementService {

    @Autowired
    private StatementRepository statementRepository;


    @Override
    public Statement findByName(String name) {
        return statementRepository.findByValue(name);
    }
}
