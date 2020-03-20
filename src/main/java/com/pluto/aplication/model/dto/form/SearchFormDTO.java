package com.pluto.aplication.model.dto.form;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * Created by jose eduardo on 3/20/2020.
 */
@Data
@Component
public class SearchFormDTO {


    private String content;

    public SearchFormDTO(){}
}
