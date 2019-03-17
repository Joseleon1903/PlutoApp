package com.pluto.aplication.controller.categoryview;

import java.security.Principal;
import java.util.List;
import com.pluto.aplication.mapping.ItemsMapping;
import com.pluto.aplication.model.dto.ItemDTO;
import com.pluto.aplication.model.dto.form.ItemFilterFormData;
import com.pluto.aplication.model.entity.ItemType;
import com.pluto.aplication.model.entity.Items;
import com.pluto.aplication.service.implementation.ItemTypeService;
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

@Controller
public class CategoryViewItemController{

    @Autowired
    private ItemTypeService itemTypeService;  
    
    @Autowired
    private ItemsServiceImpl itemsServiceImpl;
    
    @Autowired
    private ItemFilterFormData itemFilterFormData;

    @Autowired
    private ShoppingStoreInterfaces shoppingStoreServiceImpl;

    List<ItemDTO> itemList;

    private String currentCategoryName;

    @RequestMapping(value={"/items/category/view"})
    public String displayPage(Model  model,  @RequestParam("category") String category ){
        System.out.println("displayPage entry point.");
        System.out.println("entry param: "+category);
        currentCategoryName = category;
        ItemType itemtypeEntity = itemTypeService.findByName(category);
        if(itemtypeEntity == null){
            System.out.println("category not exit..");
        }
        List<Items> listItems = itemsServiceImpl.findByProviderName(itemtypeEntity.getName());
        itemList = ItemsMapping.getItemsList(listItems);

        model.addAttribute("filterformData",itemFilterFormData);
        model.addAttribute("itemsList",itemList);
        model.addAttribute("categoryName",category);
        return "/category-view-item/categoryView";
    }


    @RequestMapping(value="/category/filter/items" , method = RequestMethod.POST)
    public String formFilterList(@ModelAttribute(value="itemTypeFormData") ItemFilterFormData formData, @RequestParam("category") String category ,Model model){
        System.out.println("entry point formFilterList");
        System.out.println("param : "+formData.getName() );
        System.out.println("param : "+ formData.getMinPrice());
        System.out.println("param : "+ formData.getMaxPrice());
        System.out.println("param : "+ category);

        List<Items> listEntity= itemsServiceImpl.findFilterParamCategory("%"+formData.getName()+"%", formData.getMinPrice(),formData.getMaxPrice(),category);
        itemList = ItemsMapping.getItemsList(listEntity);
        model.addAttribute("itemsList",itemList);
        model.addAttribute("filterformData",itemFilterFormData);
        model.addAttribute("categoryName",category);
        System.out.println("list Size: "+ itemList.size());
        return "/category-view-item/categoryView.html";
    }

    @RequestMapping(value="/items/category/buy")
    public String addItemToShoppingCar(ModelMap  model,  @RequestParam("itemId") String itemId , Principal pincipal){
        System.out.println("entry point addItemToShoppingCar");
        System.out.println("param : "+itemId);
        String username = pincipal.getName();
        long itemLong = Long.parseLong(itemId);
        shoppingStoreServiceImpl.addProductToShoppingCar(itemLong, username);
        System.out.println("category  : "+currentCategoryName);
        model.addAttribute("filterformData",itemFilterFormData);
        model.addAttribute("itemsList",itemList);
        return "redirect:/items/category/view?category="+currentCategoryName;
    }

}