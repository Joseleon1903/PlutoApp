package com.pluto.aplication.controller.maintenance;

import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import com.pluto.aplication.constant.ConstantAplication;
import com.pluto.aplication.constant.UtilityAplication;
import com.pluto.aplication.mapping.ItemTypeMapping;
import com.pluto.aplication.model.dto.GenericErrorDTO;
import com.pluto.aplication.model.dto.ItemTypeDTO;
import com.pluto.aplication.model.dto.PaginationDTO;
import com.pluto.aplication.model.dto.form.ItemTypeFormData;
import com.pluto.aplication.model.entity.ItemType;
import com.pluto.aplication.service.implementation.ItemTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MaintenanceController{

    @Autowired
    private ItemTypeService itemTypeService;

    @Autowired
    private ItemTypeFormData itemTypeForm;

    @Autowired
    private GenericErrorDTO errrorDTO;

    @Autowired
    private PaginationDTO pagination;

    List<ItemTypeDTO> listItemType;

    @RequestMapping(value={"/maintenance/","/maintenance"})
    public String displayPage(ModelMap  model,  @RequestParam(value="page",required = false) String page){
        System.out.println("displayPage entry point");
        errrorDTO.clear();

        Page<ItemType> listPaginated = null;
        System.out.println("begin search list itemType");
        if(page != null && listPaginated== null){
            System.out.println("etrando if");
            listPaginated = itemTypeService.findAllWithPagination(UtilityAplication.createPageableCustom(Integer.parseInt(page)-1, 10));
        }else{
            System.out.println("entrando else");
            listPaginated = itemTypeService.findAllWithPagination(UtilityAplication.createPageableDefault());
        }

        pagination.setNumberPage(listPaginated.getTotalPages());
        pagination.setNumberRow(listPaginated.getNumberOfElements());
        List<ItemType> listEntityType = listPaginated.getContent();
        listItemType = ItemTypeMapping.getLisCategory(listEntityType);
        System.out.println("End search list itemType");

        model.addAttribute("listItemType",listItemType);
        model.addAttribute("itemTypeForm",itemTypeForm);
        model.addAttribute("pagination",pagination);

        model.addAttribute("error", errrorDTO);
        return "/maintenance/Maintenance";
    }

    @RequestMapping(value ="/registration/itemType", method = RequestMethod.POST)
    public String postItemTypeForm(@Valid @ModelAttribute(value="itemTypeFormData") ItemTypeFormData formData, final BindingResult bindingResult,ModelMap model){
        System.out.println("listener entry point.");
        System.out.println("providedData: "+formData);
        //validate data imput
        if(bindingResult.hasErrors()){
            System.out.println("listener found error.");
            errrorDTO.setErrorDetail(ConstantAplication.FORM_BLANK_VALUE);
            errrorDTO.getFieldError().add(bindingResult.getFieldError().getField());
            model.addAttribute("listItemType",listItemType);
            model.addAttribute("itemTypeForm", formData);
            model.addAttribute("pagination",pagination);
            model.addAttribute("error", errrorDTO);
            return "/maintenance/maintenance.html";
        }

        ItemType typeEntity = new ItemType();
        typeEntity.setCode(formData.getCode());
        typeEntity.setDescription(formData.getDescription());
        typeEntity.setName(formData.getName());
        typeEntity.setState(true);
        typeEntity.setCreationDate(new Date());

        itemTypeService.save(typeEntity);

        model.addAttribute("error", errrorDTO);
        model.addAttribute("listItemType",listItemType);
        model.addAttribute("itemTypeForm",itemTypeForm);
        model.addAttribute("pagination",pagination);
        model.clear();
        return "redirect:/maintenance";
    }

    @RequestMapping(value={"/maintenance/type/disable"})
    public String incativeItemType(ModelMap  model,  @RequestParam("typeId") String typeId){
        System.out.println("incativeItemType entry point");
        System.out.println("input typeID : "+ typeId);
        ItemType entity = itemTypeService.findById(Long.parseLong(typeId));
        entity.setState(false);
        itemTypeService.save(entity);
        return "redirect:/maintenance";
    } 

}