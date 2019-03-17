package com.pluto.aplication.service.controller;

import java.util.List;
import com.pluto.aplication.model.entity.Provided;
import com.pluto.aplication.service.interfaces.ProviderInterfaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/provided")
public class ProvidedRestController{

    @Autowired
    private ProviderInterfaces providerServiceImpl;

    @RequestMapping(value="/findAll", method = RequestMethod.GET,produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<Provided>> findAll(Pageable pageable){
        Page<Provided> lista = providerServiceImpl.findAllProviders(pageable);
        List<Provided> listpage = lista.getContent();
        return new ResponseEntity<List<Provided>>(listpage, HttpStatus.OK);
    }
    
    @RequestMapping(value="/findByText/{text}/{page}/{size}", method = RequestMethod.GET,produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<Provided>> findByTextSearch(@PathVariable("text") String text, Pageable pageable){
        Page<Provided> lista = providerServiceImpl.findProvidersByName(text, pageable);
        List<Provided> listpage = lista.getContent();
        return new ResponseEntity<List<Provided>>(listpage, HttpStatus.OK);
    }

}