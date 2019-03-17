package com.pluto.aplication.controller.provider;

import com.pluto.aplication.model.dto.form.ProviderFormData;
import com.pluto.aplication.model.entity.Provided;
import com.pluto.aplication.service.interfaces.ProviderInterfaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProviderController{

    @Autowired
    private ProviderFormData providerForm;

    @Autowired
    private ProviderInterfaces providedServiceImpl;

    @RequestMapping(value ="/provider/register", method = RequestMethod.GET)
    public String displayProviderForm(Model model){
        model.addAttribute("providedDTO", providerForm);
        return "provider/register/RegistrationProvider";
    }

    @RequestMapping(value ="/postProviderForm", method = RequestMethod.POST)
    public String postProviderForm(@ModelAttribute(value="providerData") ProviderFormData providedData,Model model){
        System.out.println("listener entry point.");
        System.out.println("providedData: "+providedData);
        Provided prov = new Provided();
        prov.setName(providedData.getName());
        prov.setAddress(providedData.getAddress());
        prov.setEmail(providedData.getEmail());
        prov.setIsValidEmail(false);
        prov.setPhone(providedData.getPhone());
        providedServiceImpl.save(prov);
        model.addAttribute("providedDTO", providedData);
        return "redirect:/provider/register";
    }

}