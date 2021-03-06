package com.pluto.aplication.controller.profile;

import java.io.IOException;
import java.security.Principal;
import com.pluto.aplication.constant.ConstantAplication;
import com.pluto.aplication.controller.HomePageController;
import com.pluto.aplication.mapping.ProfileMapping;
import com.pluto.aplication.model.dto.EmailDTO;
import com.pluto.aplication.model.dto.form.ProfileFormData;
import com.pluto.aplication.model.entity.EmailTemplate;
import com.pluto.aplication.model.entity.ImagesData;
import com.pluto.aplication.model.entity.SystemUser;
import com.pluto.aplication.service.implementation.FileServiceImpl;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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

    @Autowired
    private ProfileFormData profileFormData;

    @RequestMapping(value ="/profile", method = RequestMethod.GET)
    public String DisplayUserProfile(Model model, Principal principal){
        logger.info("entering DisplayUserProfile");
        SystemUser user = userService.findByUsername(principal.getName());
        System.out.println("user : "+ user);
        profileFormData = ProfileMapping.convertFromEntity(user);
        model.addAttribute("profileBean",profileFormData );
        return "profile/UserProfile";
    }

    @RequestMapping(value = "/profile/update", method = RequestMethod.POST)
    public String updateUserForm(@ModelAttribute(value="user") ProfileFormData user, Model model, Principal pincipal){
        logger.info("entering updateUserForm");
        SystemUser usuarioUpdate =userService.findByUsername(pincipal.getName());
        usuarioUpdate.getProfile().setFirstName(user.getFirstName());
        usuarioUpdate.getProfile().setLastName(user.getLastName());
        usuarioUpdate.getProfile().setEmail(user.getEmail());
        usuarioUpdate.getProfile().setMobilePhone(user.getMobilePhone());
        userService.updateUser(usuarioUpdate);

       //enviando email usuario actualizado con exito.
       EmailTemplate template = emailTemplateService.findByCode(ConstantAplication.UPDATE_USER_PROFILE);

       EmailDTO email = new EmailDTO();
       email.setHeader(template.getHeader());
       email.setDestinationEmail(usuarioUpdate.getProfile().getEmail());
       email.setContent(template.getContent());
       emailServiceImpl.sendEmailTo(email);
       profileFormData = ProfileMapping.convertFromEntity(usuarioUpdate);
       model.addAttribute("profileBean",profileFormData);
       model.addAttribute("username", usuarioUpdate.getUsername());
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
         if(image!=null){
            SystemUser usuarioUpdate =userService.findByUsername(profileFormData.getUsername());
            usuarioUpdate.getProfile().setImage(image);
            usuarioUpdate =userService.updateUser(usuarioUpdate);
            profileFormData= ProfileMapping.convertFromEntity(usuarioUpdate);
         }

         model.addAttribute("profileBean",profileFormData);
         model.addAttribute("username", profileFormData.getUsername());
         // Redirect to a successful upload page 
         return "profile/UserProfile";
    }

}
