package com.pluto.aplication.controller.items;

import java.security.Principal;
import com.pluto.aplication.mapping.ItemsMapping;
import com.pluto.aplication.model.dto.ItemDTO;
import com.pluto.aplication.model.entity.Items;
import com.pluto.aplication.service.implementation.ItemsServiceImpl;
import com.pluto.aplication.service.interfaces.ShoppingStoreInterfaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ItemDetailController{

    @Autowired
    private ItemsServiceImpl itemsServiceImpl;

    @Autowired
    private ShoppingStoreInterfaces shoppingStoreServiceImpl;

    @Autowired
    private ItemDTO itemDetail;

    @RequestMapping(value={"/items/detail/view"})
    public String displayPage(Model  model,  @RequestParam("itemId") String itemId ){
        System.out.println("displayPage entry point.");
        long id = Long.parseLong(itemId);
        Items item = itemsServiceImpl.findbyId(id);
        itemDetail = ItemsMapping.getItemsFromEntity(item);
        model.addAttribute("itemDetail", itemDetail);
        return "items/ItemDetailPage";
    }

    @RequestMapping(value="/items/detail/buy")
    public String addItemToShoppingCar(ModelMap  model,  @RequestParam("itemId") String itemId , Principal pincipal){
        System.out.println("entry point addItemToShoppingCar");
        System.out.println("param : "+itemId);
        String username = pincipal.getName();
        long itemLong = Long.parseLong(itemId);
        shoppingStoreServiceImpl.addProductToShoppingCar(itemLong, username);
        return "redirect:items/detail/view?itemId="+itemId;
    }

}