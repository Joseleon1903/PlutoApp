package com.pluto.aplication.controller.provider;

import java.security.Principal;
import java.util.List;
import com.pluto.aplication.constant.UtilityAplication;
import com.pluto.aplication.model.dto.SearchTextDTO;
import com.pluto.aplication.model.entity.Provided;
import com.pluto.aplication.service.interfaces.ProviderInterfaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ListProviderController{

    @Autowired
    private ProviderInterfaces providerServiceImpl;

    @Autowired
    private SearchTextDTO textSearchBean;

    @RequestMapping(value ="/provider/list-provider", method = RequestMethod.GET)
    public String displayProviderForm(Model model){
    List<Provided> listProv =  providerServiceImpl.findAllProviders( UtilityAplication.createPageableDefault()).getContent();
    model.addAttribute("listProvider", listProv);
    model.addAttribute("searchBean",textSearchBean);
        return "provider/list/ListProviderRegistered";
    }
    
    @RequestMapping(value ="/provider/list-provider/search", method = RequestMethod.POST)
    public String searchInListProviderPage(@ModelAttribute(value="textSearch") SearchTextDTO  textSearch , Model model, Principal principal){
        List<Provided> listProv  = providerServiceImpl.findProvidersByName(textSearch.getContent(), UtilityAplication.createPageableDefault()).getContent();
        model.addAttribute("listProvider", listProv);
        model.addAttribute("searchBean",textSearch);
        return  "provider/list/ListProviderRegistered";
    }
}