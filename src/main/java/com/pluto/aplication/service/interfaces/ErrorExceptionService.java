package com.pluto.aplication.service.interfaces;

import java.util.List;
import com.pluto.aplication.model.entity.ErrorException;

public interface ErrorExceptionService {

    ErrorException findByCode(long code);    
    
    List<ErrorException> findAll();

    List<ErrorException> findAllActive();

    ErrorException save(ErrorException errorException);    

}