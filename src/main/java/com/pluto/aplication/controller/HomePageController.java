package com.pluto.aplication.controller;

import java.security.Principal;
import java.util.List;
import com.pluto.aplication.mapping.ItemsMapping;
import com.pluto.aplication.model.dto.ItemDTO;
import com.pluto.aplication.model.dto.form.ItemFilterFormData;
import com.pluto.aplication.model.entity.Items;
import com.pluto.aplication.service.implementation.ItemsServiceImpl;
import com.pluto.aplication.service.interfaces.ShoppingStoreInterfaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * joseleon
 * 
 */
@Controller
public class HomePageController {

    @Autowired
    private ItemsServiceImpl itemsServiceImpl;

    @Autowired
    private ItemFilterFormData itemFilterFormData;

    @Autowired
    private ShoppingStoreInterfaces shoppingStoreServiceImpl;

    List<ItemDTO> itemList;

    @RequestMapping({ "/home", "/"})
    public String loginPage(Model model){
        System.out.println("entry point display home");
        List<Items> listEntity= itemsServiceImpl.findAll();
        itemList = ItemsMapping.getItemsList(listEntity);
        model.addAttribute("filterformData",itemFilterFormData);
        model.addAttribute("itemsList",itemList);
        return "/dashboard/HomePage";
    }

    @RequestMapping(value="/home/filter/items" , method = RequestMethod.POST)
    public String formFilterList(@ModelAttribute(value="itemTypeFormData") ItemFilterFormData formData,Model model){
        System.out.println("entry point formFilterList");
        System.out.println("param : "+formData.getName());
        System.out.println("param : "+ formData.getMinPrice());
        System.out.println("param : "+ formData.getMaxPrice());

        List<Items> listEntity= itemsServiceImpl.findFilterParam("%"+formData.getName()+"%", formData.getMinPrice(),formData.getMaxPrice());
        itemList = ItemsMapping.getItemsList(listEntity);
        model.addAttribute("itemsList",itemList);
        model.addAttribute("filterformData",itemFilterFormData);
        System.out.println("list Size: "+ itemList.size());
        return "/dashboard/HomePage.html";
    }

    @RequestMapping(value="/home/buy/item")
    public String addItemToShoppingCar(ModelMap  model,  @RequestParam("itemId") String itemId , Principal pincipal){
        System.out.println("entry point addItemToShoppingCar");
        System.out.println("param : "+itemId);
        String username = pincipal.getName();
        long itemLong = Long.parseLong(itemId);
        shoppingStoreServiceImpl.addProductToShoppingCar(itemLong, username);
        model.addAttribute("filterformData",itemFilterFormData);
        model.addAttribute("itemsList",itemList);
        return "redirect:/home";
    }

}
