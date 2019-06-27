package com.pluto.aplication.controller.checkout;

import java.security.Principal;
import com.pluto.aplication.service.implementation.ShoppingStoreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShopCheckoutController{

    @Autowired
    private ShoppingStoreServiceImpl shoppingStoreServiceImpl;

    @RequestMapping(value={"/checkout/product/view"})
    public String displayPage(Model  model){
        System.out.println("displayPage entry point.");
        return "checkout/ShopCheckoutPage";
    }

    @RequestMapping(value={"/checkout/product/cancel"})
    public String cancelShoppingCar(ModelMap  model, Principal principal){
        System.out.println("cancelShoppingCar...");
        String username = principal.getName();
        shoppingStoreServiceImpl.removeAllProductToShoppingCar(username);
        return "redirect:checkout/product/view";
    } 

    @RequestMapping(value={"/checkout/product/confirm"})
    public String confirmShoppingCar(ModelMap  model, Principal principal){
        System.out.println("condfirmShoppingCar...");
        String username = principal.getName();
        shoppingStoreServiceImpl.removeAllProductToShoppingCar(username);
        return "redirect:checkout/product/view/confirmation";
    }

}