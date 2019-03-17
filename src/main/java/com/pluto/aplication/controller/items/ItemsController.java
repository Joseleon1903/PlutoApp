package com.pluto.aplication.controller.items;

import java.io.IOException;
import java.util.List;
import javax.validation.Valid;
import com.pluto.aplication.constant.ConstantAplication;
import com.pluto.aplication.constant.UtilityAplication;
import com.pluto.aplication.mapping.ItemTypeMapping;
import com.pluto.aplication.mapping.ProviderMapping;
import com.pluto.aplication.model.dto.GenericErrorDTO;
import com.pluto.aplication.model.dto.ItemTypeDTO;
import com.pluto.aplication.model.dto.ProviderDTO;
import com.pluto.aplication.model.dto.form.ItemFormData;
import com.pluto.aplication.model.entity.ImagesData;
import com.pluto.aplication.model.entity.ItemType;
import com.pluto.aplication.model.entity.Items;
import com.pluto.aplication.model.entity.Provided;
import com.pluto.aplication.service.implementation.ImageServiceImpl;
import com.pluto.aplication.service.implementation.ItemTypeService;
import com.pluto.aplication.service.implementation.ItemsServiceImpl;
import com.pluto.aplication.service.implementation.ProviderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ItemsController{

    @Autowired
    private GenericErrorDTO errrorDTO;

    @Autowired
    private ItemFormData itemFormData;

    @Autowired
    private ItemTypeService itemTypeService;

    @Autowired
    private ProviderServiceImpl providerService;

    @Autowired
    private ImageServiceImpl imageServiceImpl;

    @Autowired
    private ItemsServiceImpl itemsServiceImpl;

    private List<ItemTypeDTO> categoryName;

    private List<ProviderDTO> providedList;

    @RequestMapping({ "/items"})
    public String displayPage(ModelMap  model){
        System.out.println("displayPage entry point.");

        List<ItemType> listCategory = itemTypeService.findAll();
        categoryName = ItemTypeMapping.getLisCategory(listCategory);

        Page<Provided> listPrivider = providerService.findAllProviders(UtilityAplication.createPageableCustom(0, 10));
        providedList = ProviderMapping.getProviderList(listPrivider);

        errrorDTO.clear();
        model.addAttribute("itemForm",new ItemFormData());
        model.addAttribute("categoryList",categoryName);
        model.addAttribute("providerList",providedList);
        System.out.println("displayPage entry point. data: "+itemFormData );
        model.addAttribute("error", errrorDTO);
        return "/items/ItemsPage";
    }

    @RequestMapping(value ="/registration/item", method = RequestMethod.POST)
    public String postItemTypeForm(@Valid @ModelAttribute(value="itemFormData") ItemFormData formData, final BindingResult bindingResult,ModelMap model){
        System.out.println("listener entry point.");
        System.out.println("FormData: "+formData);
        //validate data imput
        if(bindingResult.hasErrors()){
            System.out.println("listener found error.");
            errrorDTO.setErrorDetail(ConstantAplication.FORM_BLANK_VALUE);
            errrorDTO.getFieldError().add(bindingResult.getFieldError().getField());
            model.addAttribute("itemForm", formData);
            model.addAttribute("categoryList",categoryName);
            model.addAttribute("providerList",providedList);
            model.addAttribute("error", errrorDTO);
            return "/items/ItemsPage.html";
        }

        Items newItems = new Items();
        newItems.setName(formData.getName());
        newItems.setDescription(formData.getDescription());
        newItems.setPrice(formData.getPrice());
        ItemType typeEntity = itemTypeService.findById(formData.getItemTypeId());
        newItems.setItemType(typeEntity);
        Provided prov = providerService.findById(formData.getProvideId());
        newItems.setProvided(prov);

        System.out.println("itemFormData: "+ itemFormData);
        if(itemFormData.getImageId() != null){
            ImagesData imgData = imageServiceImpl.findbyId(itemFormData.getImageId());
            newItems.setImage(imgData);
            itemFormData =  new ItemFormData();
        }

        itemsServiceImpl.save(newItems);
    
        model.addAttribute("categoryList",categoryName);
        model.addAttribute("error", errrorDTO);
        model.addAttribute("itemTypeForm",itemFormData);
        model.addAttribute("providerList",providedList);
        model.clear();
        return "redirect:/items";
    }

    @RequestMapping(value = "/item/fileUpload", method = RequestMethod.POST) 
    public String updateItemPicture(@RequestParam("myFile") MultipartFile myFile, Model model) { 
        System.out.println("entering updateItemPicture");
        //validando file not null
        if(myFile.isEmpty()){
            model.addAttribute("categoryList",categoryName);
            model.addAttribute("error", errrorDTO);
            model.addAttribute("itemTypeForm",itemFormData);
            model.addAttribute("providerList",providedList);
            // Redirect to a successful upload page 
            return "redirect:/items";
        }

        try {
            ImagesData img = imageServiceImpl.createImage(myFile);
            itemFormData.setImageId(img.getId());
            itemFormData.setPictureUrl(img.getFileViewUri());
        } catch (IOException e) {
            System.out.println("Error upload image");
            e.printStackTrace();
		}

        model.addAttribute("categoryList",categoryName);
        model.addAttribute("error", errrorDTO);
        model.addAttribute("itemTypeForm",itemFormData);
        model.addAttribute("providerList",providedList);
         // Redirect to a successful upload page 
         return "redirect:/items/update";
    } 

    @RequestMapping("/items/update")
    public String displayUpdate(ModelMap  model){
        System.out.println("displayPage entry point.");

        List<ItemType> listCategory = itemTypeService.findAll();
        categoryName = ItemTypeMapping.getLisCategory(listCategory);

        Page<Provided> listPrivider = providerService.findAllProviders(UtilityAplication.createPageableCustom(0, 10));
        providedList = ProviderMapping.getProviderList(listPrivider);

        errrorDTO.clear();
        model.addAttribute("itemForm",itemFormData);
        model.addAttribute("categoryList",categoryName);
        model.addAttribute("providerList",providedList);
        System.out.println("displayPage entry point. data: "+itemFormData );
        model.addAttribute("error", errrorDTO);
        return "/items/ItemsPage";
    }
    
}