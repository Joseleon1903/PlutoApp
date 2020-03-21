package com.pluto.aplication.model.dto.form;

import lombok.Data;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by jose eduardo on 3/21/2020.
 */
@Data
@Component
public class IterationFormData implements InitializingBean {

    public Long projectId;
    public Long id;
    public String name;
    public String description;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date InitDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    public IterationFormData(){}

    @Override
    public void afterPropertiesSet() throws Exception {
        InitDate =new Date();
        endDate = new Date();
    }

}
