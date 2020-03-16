package com.pluto.aplication.mock;

import com.pluto.aplication.model.entity.*;
import com.pluto.aplication.repository.ImagesDataRepository;
import com.pluto.aplication.repository.PriorityRepository;
import com.pluto.aplication.service.implementation.EmailTemplateService;
import com.pluto.aplication.service.interfaces.ErrorExceptionInterface;
import com.pluto.aplication.service.interfaces.UserInterfaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by jleon on 6/5/2018.
 */
@Component
public class MockUsuario implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private UserInterfaces userService;

    @Autowired
    private ErrorExceptionInterface errorExceptionService;

    @Autowired
    private EmailTemplateService emailTemplateService;

    @Autowired
    private ImagesDataRepository imagesDataRepository;

    @Autowired
    private PriorityRepository priorityRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent){
        initUserData();
    }

    public void initUserData(){
        System.out.println("inicializando data de usuario");

        ImagesData data =ImageMockDataBase();

        User user = new User();
        user.setId(1);
        user.setUsername("ADMIN");
        user.setPassword("ADMIN123");
        Profile profile = new Profile();
        profile.setId(1);
        profile.setFirstName("Jose");
        profile.setLastName("De Leon");
        profile.setEmail("joseleon@gmail.com");
        profile.setMobilePhone("809-445-7563");
        user.setProfile(profile);
        user.getProfile().setImage(data);
        User userC = userService.createUser(user);
        System.out.println("Usuario: "+ userC );
        System.out.println("Terminando inicializando data de usuario");

        CatalogErrorInit();

        CatalogEmailTemplateInit();

        ImageMockItemDataBase();

        CatalogPriority();

    }

    public void CatalogErrorInit(){
        List<ErrorException> listError = new ArrayList<>();
        ErrorException  errorE = null;
        //invalid Autentication Error
        errorE = new ErrorException();
        errorE.setCode(501);
        errorE.setDescription("Check that you have used the correct email and password combination for the account you are trying to access.");
        errorE.setStatus(true);
        listError.add(errorE);

        //invalid confirm password
        errorE = new ErrorException();
        errorE.setCode(502);
        errorE.setDescription("Password does not match the confirm password.");
        errorE.setStatus(true);
        listError.add(errorE);

        //invalid username
        errorE = new ErrorException();
        errorE.setCode(503);
        errorE.setDescription("Duplicate Username: the username already exists");
        errorE.setStatus(true);
        listError.add(errorE);

        ///registration error
        System.out.println("List Error : "+listError );
        for (ErrorException var : listError) {
            errorExceptionService.save(var);
        }

    }

    public void CatalogEmailTemplateInit(){
        System.out.println("---------- Inizializando data Email --------------" );
        EmailTemplate  eTemplate = new EmailTemplate();
        eTemplate.setCode("Email_new_registration");
        eTemplate.setHeader("Welcome thanks for your registration");
        eTemplate.setContent("The welcome email one of the worlds leading aplication, "
        +"is quite discreet. This type of email isn’t usually recommended, as there is very little hook to the message.");
        emailTemplateService.save(eTemplate);

        eTemplate = new EmailTemplate();
        eTemplate.setCode("Update_user_profile");
        eTemplate.setHeader("Welcome thanks for update your profile");
        eTemplate.setContent("Hello, we thank you for updating your profile data.");
        emailTemplateService.save(eTemplate);
    }

    public ImagesData ImageMockDataBase(){
        System.out.println("---------- ImageMockDataBase initialization --------------" );
        String fileName= "unknow-profile.png";
        ImagesData entity = new ImagesData();
        entity.setName(fileName);
        entity.setFileDownloadUri("http://localhost:8085/api/file/downloadFile/"+ fileName);
        entity.setFileType("png");
        entity.setCreationDate(new Date());
        entity.setUpdateDate(new Date());
        entity.setFileViewUri("http://localhost:8085/api/file/view/image/"+fileName );
        entity =imagesDataRepository.save(entity);
        return entity;
    }

    public ImagesData ImageMockItemDataBase(){
        System.out.println("---------- ImageMockItemDataBase initialization --------------" );
        String fileName= "wall-box.jpg";
        ImagesData entity = new ImagesData();
        entity.setName(fileName);
        entity.setFileDownloadUri("http://localhost:8085/api/file/downloadFile/"+ fileName);
        entity.setFileType("png");
        entity.setCreationDate(new Date());
        entity.setUpdateDate(new Date());
        entity.setFileViewUri("http://localhost:8085/api/file/view/image/"+fileName );
        entity =imagesDataRepository.save(entity);
        return entity;
    }

    public void CatalogPriority(){

        Priority entity = new Priority();

        entity .setValue("HIGH");

        priorityRepository.save(entity);

        Priority entity1 = new Priority();

        entity1.setValue("MEDIUM");

        priorityRepository.save(entity1);

        Priority entity2 = new Priority();

        entity2.setValue("LOW");

        priorityRepository.save(entity2);
    }

}
