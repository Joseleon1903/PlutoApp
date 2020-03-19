package com.pluto.aplication.controller.project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jose eduardo on 3/19/2020.
 */
@Controller
public class ProjectPageController {

    @RequestMapping("/project")
    public String loginPage(Model model){
        System.out.println("entry point display home");
        return "project/ProjectPage";
    }


}
