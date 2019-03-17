package com.pluto.aplication.controller.checkout;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShopSucessesController{

    @RequestMapping(value={"/checkout/product/view/confirmation"})
    public String displayPage(Model  model){
        System.out.println("displayPage entry point.");
        return "/checkout/ShopCheckoutFinalPage";
    }

}