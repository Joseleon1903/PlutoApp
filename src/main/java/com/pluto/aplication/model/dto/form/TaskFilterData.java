package com.pluto.aplication.model.dto.form;

import lombok.Data;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * Created by jose eduardo on 4/6/2020.
 */
@Data
@Component
public class TaskFilterData implements InitializingBean {

    private String type;

    private String priority;

    private String done;

    @Override
    public void afterPropertiesSet() throws Exception {
        this.type = "All";
        this.done = "All";
        this.priority = "All";

    }
}
