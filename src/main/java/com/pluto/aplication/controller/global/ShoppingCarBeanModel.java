package com.pluto.aplication.controller.global;

import com.pluto.aplication.constant.ConstantAplication;
import com.pluto.aplication.mapping.ShoppingStoreMapping;
import com.pluto.aplication.model.dto.ShoppingStoreDTO;
import com.pluto.aplication.model.entity.ShoppingStore;
import com.pluto.aplication.service.interfaces.ShoppingStoreInterfaces;
import com.pluto.aplication.util.AplicationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice(annotations = Controller.class)
public class ShoppingCarBeanModel{
   
    @Autowired
    private ShoppingStoreInterfaces shoppingStoreService;

    @ModelAttribute("shoppingCar")
    public ShoppingStoreDTO getCurrentShoppingCar() {
       System.out.println("Entrando metodo getCurrentShoppingCar");
       ShoppingStoreDTO type = new ShoppingStoreDTO();
       Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
       String currentPrincipalName = ConstantAplication.ANONYMOUS_USER;
       if(authentication !=null){
         currentPrincipalName = authentication.getName();
       }
       System.out.println("currentePrincipalname: "+ currentPrincipalName);
       if(ConstantAplication.ANONYMOUS_USER.equalsIgnoreCase(currentPrincipalName)){
           return type;
       }
       ShoppingStore shop = shoppingStoreService.currentShoppingCarStatus(currentPrincipalName);
       if(shop !=null){
          type = ShoppingStoreMapping.convertFromEntity(shop);
          String pastTime = AplicationUtil.timePastFromDate(type.getUpdate());
          type.setTimePast(pastTime);
       }
       return type;
    }

}