package com.pluto.aplication.controller;

import com.pluto.aplication.service.interfaces.ProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    Logger logger = LoggerFactory.getLogger(HomePageController.class);

    @Autowired
    private ProjectService projectService;

    @RequestMapping({ "/home", "/"})
    public String loginPage(Model model){
        logger.info("------- entering -----------");
        logger.info("Entering in method loginPage..");
        model.addAttribute("projectBeanList",projectService.findAllProjects());
        return "dashboard/HomePage";
    }

}
