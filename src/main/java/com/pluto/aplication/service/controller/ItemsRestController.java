package com.pluto.aplication.service.controller;

import java.util.List;
import com.pluto.aplication.model.entity.Items;
import com.pluto.aplication.service.interfaces.ItemsIntefaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jose Eduardo on 5/31/2018.
 */
@RestController
@RequestMapping("/api/items")
public class ItemsRestController{

    @Autowired
    private ItemsIntefaces itemsIntefaces;

    @RequestMapping(value="/findAll", method = RequestMethod.GET,produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<Items>> findAll(){
        List<Items> itemList = itemsIntefaces.findAll();
        return new ResponseEntity<List<Items>>(itemList, HttpStatus.OK);
    }

}