package com.pluto.aplication.controller;

import com.pluto.aplication.service.interfaces.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * joseleon
 * 
 */
@Controller
public class HomePageController {


    @Autowired
    private ProjectService projectService;

    @RequestMapping({ "/home", "/"})
    public String loginPage(Model model){
        System.out.println("entry point display home");

        model.addAttribute("projectBeanList",projectService.findAllProjects());

        return "dashboard/HomePage";
    }

}
