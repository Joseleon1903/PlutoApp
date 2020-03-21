package com.pluto.aplication.mapping;

import com.pluto.aplication.model.dto.form.IterationFormData;
import com.pluto.aplication.model.entity.Iteration;

import java.util.Date;

/**
 * Created by jose eduardo on 3/21/2020.
 */
public class IterationMapping {

    /**
     *
     * @param iterationFormData
     * @return
     */
    public static Iteration convertToFormDto(IterationFormData iterationFormData){

        Iteration entity = new Iteration();
        entity.setName(iterationFormData.getName());
        entity.setDescription(iterationFormData.getDescription());
        entity.setCreationDate(new Date());
        entity.setEndDate(iterationFormData.getEndDate());
        entity.setInitDate(iterationFormData.getInitDate());
        entity.setActive(true);

        return entity;
    }



}
