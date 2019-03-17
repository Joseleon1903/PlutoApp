package com.pluto.aplication.service.controller;

import com.pluto.aplication.mapping.ShoppingStoreMapping;
import com.pluto.aplication.model.dto.ShoppingStoreDTO;
import com.pluto.aplication.model.entity.ShoppingStore;
import com.pluto.aplication.service.interfaces.ShoppingStoreInterfaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/shopping/store")
public class ShoppingStoreRestController{

    @Autowired
    private ShoppingStoreInterfaces shoppingStoreService;

    @RequestMapping(value="/add", method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ShoppingStoreDTO> addShoppingItem(@RequestParam("itemId") Long id,@RequestParam("username") String username ){
        ShoppingStore shop = shoppingStoreService.addProductToShoppingCar(id, username);
        ShoppingStoreDTO dto = ShoppingStoreMapping.convertFromEntity(shop);
        return new ResponseEntity<ShoppingStoreDTO>(dto, HttpStatus.OK);
    }

    @RequestMapping(value="/remove", method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ShoppingStoreDTO> removeShoppingItem(@RequestParam("itemId") Long id,@RequestParam("username") String username ){
        long shop = shoppingStoreService.removeProductToShoppingCar(id, username);
        ShoppingStoreDTO outPut = new ShoppingStoreDTO(shop);
        return new ResponseEntity<ShoppingStoreDTO>(outPut, HttpStatus.OK);
    }

    @RequestMapping(value="/status", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ShoppingStoreDTO> statusShoppingCar(@RequestParam("username") String username ){
        ShoppingStore shop = shoppingStoreService.currentShoppingCarStatus(username);
        ShoppingStoreDTO dto = new ShoppingStoreDTO();
        if(shop != null){
            dto = ShoppingStoreMapping.convertFromEntity(shop);
        }
        return new ResponseEntity<ShoppingStoreDTO>(dto, HttpStatus.OK);
    }

}