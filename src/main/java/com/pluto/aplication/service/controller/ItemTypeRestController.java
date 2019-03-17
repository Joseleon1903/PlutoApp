package com.pluto.aplication.service.controller;

import java.util.List;
import com.pluto.aplication.model.entity.ItemType;
import com.pluto.aplication.service.interfaces.ItemTypeInterfaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/item-type")
public class ItemTypeRestController{

    @Autowired
    private ItemTypeInterfaces itemTypeInterfaces;

    @RequestMapping(value="/findAll", method = RequestMethod.GET,produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<ItemType>> findAll(){
        List<ItemType> itemTypeList = itemTypeInterfaces.findAll();
        return new ResponseEntity<List<ItemType>>(itemTypeList, HttpStatus.OK);
    }

    @RequestMapping(value="/save", method = RequestMethod.POST,produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ItemType> findAll(@RequestBody ItemType itemType){
        ItemType item = itemTypeInterfaces.save(itemType);
        return new ResponseEntity<ItemType>(item, HttpStatus.OK);
    }

}