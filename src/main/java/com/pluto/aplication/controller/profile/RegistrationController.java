package com.pluto.aplication.controller.profile;

import com.pluto.aplication.constant.ConstantAplication;
import com.pluto.aplication.model.dto.EmailDTO;
import com.pluto.aplication.model.dto.GenericErrorDTO;
import com.pluto.aplication.model.entity.EmailTemplate;
import com.pluto.aplication.model.entity.Profile;
import com.pluto.aplication.model.entity.PlutoUser;
import com.pluto.aplication.service.implementation.ErrorExceptionService;
import com.pluto.aplication.service.implementation.UserService;
import com.pluto.aplication.service.interfaces.EmailServiceInterfaces;
import com.pluto.aplication.service.interfaces.EmailTemplateInterfaces;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegistrationController {

    Logger logger = LoggerFactory.getLogger(RegistrationController.class);

    @Autowired
    private GenericErrorDTO genericErrorDTO;

    @Autowired
    private UserService userService;

    @Autowired
    private ErrorExceptionService errorExceptionService;

    @Autowired
    private EmailServiceInterfaces emailServiceImpl;

    @Autowired
    private EmailTemplateInterfaces emailTemplateService;

    @RequestMapping(value ="/profile/register", method = RequestMethod.GET)
    public String displayRegistrationForm(Model model){
        model.addAttribute("errorBean", genericErrorDTO);
        return "profile/register/RegistrationUser";
    }

    @RequestMapping(value = "/profile/registration", method = RequestMethod.POST)
    public String registerUser(Model model){
        PlutoUser newUser =  new PlutoUser();
        Profile newProfile = new Profile();

        //enviando email registration 
        EmailTemplate template = emailTemplateService.findByCode(ConstantAplication.REGISTRATION_EMAIL_CODE);

        newUser.setProfile(newProfile);
        newUser =userService.createUser(newUser);
        logger.info("usuario registrdo: "+ newUser);
        return "profile/register/RegistrationSuccess";
    }

}
