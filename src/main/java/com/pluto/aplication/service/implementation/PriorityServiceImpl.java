package com.pluto.aplication.service.implementation;

import com.pluto.aplication.model.entity.Priority;
import com.pluto.aplication.repository.PriorityRepository;
import com.pluto.aplication.service.interfaces.PriorityService;
import org.springframework.stereotype.Service;

/**
 * Created by jose eduardo on 3/16/2020.
 */
@Service
public class PriorityServiceImpl implements PriorityService {


    private PriorityRepository priorityRepository;


    @Override
    public Priority save(Priority priority) {

       return priorityRepository.save(priority);

    }
}
