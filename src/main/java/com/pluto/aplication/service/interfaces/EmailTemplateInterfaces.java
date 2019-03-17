package com.pluto.aplication.service.interfaces;

import java.util.List;
import com.pluto.aplication.model.entity.EmailTemplate;

public interface  EmailTemplateInterfaces{

    EmailTemplate findByCode(String code);    
    
    List<EmailTemplate> findAll();

    EmailTemplate save(EmailTemplate emailTemplate);    

}