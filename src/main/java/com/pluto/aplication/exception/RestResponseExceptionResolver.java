package com.pluto.aplication.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Created by jose eduardo on 4/1/2020.
 */
@ControllerAdvice
public class RestResponseExceptionResolver extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value= Exception.class)
    protected String handleGenericException(RuntimeException ex, WebRequest request) {

        System.out.println("Entering in Advice generic exception");

        return "redirect:/system/error";
    }

}
