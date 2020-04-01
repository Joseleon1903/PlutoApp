package com.pluto.aplication.controller.error;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jose eduardo on 4/1/2020.
 */
@Controller
public class SystemErrorController {


    @RequestMapping("/system/error")
    public String displayGenericErrorPage(Model model){
        System.out.println("entry point display displayGenericErrorPage");

        return "error/GenericErrorPage";
    }


}
