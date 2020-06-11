package com.pluto.aplication.controller.Policy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

/**
 * Created by jose eduardo on 6/11/2020.
 */
@Controller
public class PolicyController {

    Logger logger = LoggerFactory.getLogger(PolicyController.class);

    @RequestMapping(value ="/policy", method = RequestMethod.GET)
    public String DisplayPolicy(Model model, Principal principal){
        logger.info("entering DisplayPolicy");
        return "policy/PolicyCompany";
    }

    @RequestMapping(value ="/termofservices", method = RequestMethod.GET)
    public String DisplayTermOfServices(Model model, Principal principal){
        logger.info("entering DisplayUserProfile");
        return "policy/TermOfService";
    }


}
