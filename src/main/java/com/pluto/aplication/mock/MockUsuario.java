package com.pluto.aplication.mock;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import com.pluto.aplication.model.entity.EmailTemplate;
import com.pluto.aplication.model.entity.ErrorException;
import com.pluto.aplication.model.entity.ImagesData;
import com.pluto.aplication.model.entity.ItemType;
import com.pluto.aplication.model.entity.Items;
import com.pluto.aplication.model.entity.Profile;
import com.pluto.aplication.model.entity.Provided;
import com.pluto.aplication.model.entity.User;
import com.pluto.aplication.repository.ImagesDataRepository;
import com.pluto.aplication.repository.ItemTypeRepository;
import com.pluto.aplication.repository.ItemsRepository;
import com.pluto.aplication.repository.ProviderRepository;
import com.pluto.aplication.service.implementation.EmailTemplateService;
import com.pluto.aplication.service.interfaces.ErrorExceptionInterface;
import com.pluto.aplication.service.interfaces.UserInterfaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

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
    private ItemTypeRepository itemTypeRepository;

    @Autowired
    private ProviderRepository providerRepository;

    @Autowired
    private ItemsRepository itemsRepository;

    @Autowired
    private ImagesDataRepository imagesDataRepository;


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

        CatalogItemType();

        CatalogProviderType();

        TestDataItems();


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

    public void CatalogItemType(){
        System.out.println("---------- Inizializando itemtype --------------" );
        ItemType itemType = new ItemType();
        String[] listNameType = {"Audio & Music", "Phone", "Camera", "Home", "VideoGames", "TV", "Motors", "Console"};
        Random rndm_method = new Random();
        System.out.println("item name catalog list length"+ listNameType.length);
        for(int i = 0; listNameType.length >i ; i++ ){
            itemType= new ItemType();
            itemType.setName(listNameType[i]);
            itemType.setDescription("Description of "+ listNameType[i]);
            itemType.setCode(listNameType[i].trim()+ "-"+rndm_method.nextInt(200));
            itemType.setCreationDate(new Date());
            itemType.setState(true);
            System.out.println("save entity: "+ itemType);
            itemTypeRepository.save(itemType);
        }
        System.out.println("---------- Finish itemtype initialization --------------" );
    }

    public void CatalogProviderType(){
        System.out.println("-------- initialization provider data--------------" );
        Provided prov = new Provided();
        prov.setName("RSC Company");
        prov.setAddress("calle primera N.5");
        prov.setEmail("rsccompany@gmail.com");
        prov.setPhone("8095647383");
        prov.setIsValidEmail(true);
        providerRepository.save(prov);

        prov = new Provided();
        prov.setName("PVP Company");
        prov.setAddress("calle primera N.6");
        prov.setEmail("pvpcompany@gmail.com");
        prov.setPhone("8095649833");
        prov.setIsValidEmail(true);

        providerRepository.save(prov);

        prov = new Provided();
        prov.setName("System Revolution");
        prov.setAddress("calle cervantes N.34");
        prov.setEmail("system-rev@gmail.com");
        prov.setPhone("8094487645");
        prov.setIsValidEmail(true);

        providerRepository.save(prov);

        System.out.println("---------- Finish Provided initialization --------------" );

    }

    public void TestDataItems(){
        System.out.println("---------- TestDataItems initialization --------------" );
        Items item = new Items();

        item.setName("televisor Lg");
        item.setPrice((double)2500);
        item.setDescription("televisor marca lg como nuevo");

        Provided prov = providerRepository.findById((long)1);
        item.setProvided(prov);

        ItemType itemType = itemTypeRepository.findById((long)6);
        item.setItemType(itemType);

        ImagesData imgData = ImageMockItemDataBase();

        item.setImage(imgData);
        itemsRepository.save(item);

        item = new Items();
        item.setName("televisor Samsung");
        item.setPrice((double)2500);
        item.setDescription("televisor marca samsug como nuevo");
        item.setProvided(prov);
        item.setItemType(itemType);
        item.setImage(imgData);
        itemsRepository.save(item);

        item = new Items();
        item.setName("televisor Sharp");
        item.setPrice((double)2500);
        item.setDescription("televisor marca Sharp como nuevo");
        item.setProvided(prov);
        item.setItemType(itemType);
        item.setImage(imgData);
        itemsRepository.save(item);

        System.out.println("----------Finish TestDataItems initialization --------------" );
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

}
