package com.pluto.aplication.controller.error;

import com.pluto.aplication.controller.HomePageController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jose eduardo on 4/1/2020.
 */
@Controller
public class SystemErrorController {

    Logger logger = LoggerFactory.getLogger(SystemErrorController.class);

    @RequestMapping("/system/error")
    public String displayGenericErrorPage(Model model){
        logger.info("entry point display displayGenericErrorPage");
        return "error/GenericErrorPage";
    }


}
