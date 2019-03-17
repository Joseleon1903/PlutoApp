package com.pluto.aplication.controller.global;

import java.util.List;
import com.pluto.aplication.model.entity.ItemType;
import com.pluto.aplication.service.implementation.ItemTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice(annotations = Controller.class)
public class CategoryBeanModel{

    @Autowired
    private ItemTypeService itemTypeService;

    @ModelAttribute("currentCategoryList")
     public List<ItemType> getCurrentItemType() {
        System.out.println("Entrando metodo getCurrentItemType");
        return itemTypeService.findAllActiveType();
     }

}