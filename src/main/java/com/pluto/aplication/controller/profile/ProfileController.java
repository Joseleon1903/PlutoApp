package com.pluto.aplication.controller.profile;

import com.pluto.aplication.model.entity.ImagesData;
import com.pluto.aplication.model.entity.PlutoUser;
import com.pluto.aplication.service.implementation.FileServiceImpl;
import com.pluto.aplication.service.implementation.UserService;
import com.pluto.aplication.service.interfaces.EmailServiceInterfaces;
import com.pluto.aplication.service.interfaces.EmailTemplateInterfaces;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;

@Controller
public class ProfileController {

    Logger logger = LoggerFactory.getLogger(ProfileController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private EmailServiceInterfaces emailServiceImpl;

    @Autowired
    private EmailTemplateInterfaces emailTemplateService;

    @Autowired
    private FileServiceImpl imageServiceImpl;


    @RequestMapping(value ="/profile", method = RequestMethod.GET)
    public String DisplayUserProfile(Model model, Principal principal){
        logger.info("entering DisplayUserProfile");
        PlutoUser user = userService.findByUsername(principal.getName());
        System.out.println("user : "+ user);
        return "profile/UserProfile";
    }

    @RequestMapping(value = "/profile/update", method = RequestMethod.POST)
    public String updateUserForm(Model model, Principal pincipal){
        logger.info("entering updateUserForm");

       return "profile/UserProfile";
    }

    @RequestMapping(value = "/fileUpload", method = RequestMethod.POST) 
    public String updateProfilePicture(@RequestParam("myFile") MultipartFile myFile,Model model) {
         logger.info("entering updateProfilePicture");
         logger.info("file name : "+ myFile.getOriginalFilename());
         ImagesData  image = null;
         try{
            image =imageServiceImpl.createImage(myFile);
         }catch(IOException ex){
            System.out.println("error update image");
         }
         // Redirect to a successful upload page 
         return "profile/UserProfile";
    }

}
