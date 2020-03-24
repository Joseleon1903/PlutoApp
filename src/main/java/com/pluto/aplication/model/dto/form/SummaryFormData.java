package com.pluto.aplication.model.dto.form;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * Created by jose eduardo on 3/24/2020.
 */
@Data
@Component
public class SummaryFormData {

    private String projectName;

    private String iterationName;

    public SummaryFormData(){};

}
