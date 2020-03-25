package com.pluto.aplication.service.interfaces;

import com.pluto.aplication.model.entity.Statement;

/**
 * Created by jose eduardo on 3/25/2020.
 */
public interface StatementService {

    Statement findByName(String name);

}
