package com.pluto.aplication.model.dto.form;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * Created by jose eduardo on 3/26/2020.
 */
@Data
@Component
public class CommentFormData {


    private Long taskId;

    private String message;

}
