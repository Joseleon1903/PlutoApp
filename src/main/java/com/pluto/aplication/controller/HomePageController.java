package com.pluto.aplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * joseleon
 * 
 */
@Controller
public class HomePageController {

    @RequestMapping({ "/home", "/"})
    public String loginPage(Model model){
        System.out.println("entry point display home");
        return "dashboard/HomePage";
    }

}
