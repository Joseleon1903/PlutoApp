package com.pluto.aplication.service.controller;

import com.pluto.aplication.model.entity.ErrorException;
import com.pluto.aplication.service.interfaces.ErrorExceptionInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Created by Jose Eduardo on 5/31/2018.
 */
@RestController
@RequestMapping("/api/exception")
public class ErrorExceptionRestController {

    @Autowired
    private ErrorExceptionInterface errorExceptionService;

    @RequestMapping(value="/findAll", method = RequestMethod.GET,produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<ErrorException>> findAll(){
        List<ErrorException> exceptionList = errorExceptionService.findAll();
        return new ResponseEntity<List<ErrorException>>(exceptionList, HttpStatus.OK);
    }

    @RequestMapping(value="/code/{code}", method = RequestMethod.GET,produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ErrorException> findByCode(@PathVariable("code") Long code){
        ErrorException exceptionE = errorExceptionService.findByCode(code);
        return new ResponseEntity<ErrorException>(exceptionE, HttpStatus.OK);
    }

    @RequestMapping(value="/findAllActive", method = RequestMethod.GET,produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<ErrorException>> findAllActive(){
        List<ErrorException> exceptionList = errorExceptionService.findAllActive();
        return new ResponseEntity<List<ErrorException>>(exceptionList, HttpStatus.OK);
    }

}