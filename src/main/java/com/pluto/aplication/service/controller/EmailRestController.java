package com.pluto.aplication.service.controller;

import com.pluto.aplication.model.dto.EmailDTO;
import com.pluto.aplication.model.dto.EmailSendDTO;
import com.pluto.aplication.model.entity.EmailTemplate;
import com.pluto.aplication.service.interfaces.EmailServiceInterfaces;
import com.pluto.aplication.service.interfaces.EmailTemplateInterfaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/email")
public class EmailRestController {

    @Autowired
    private EmailServiceInterfaces emailServiceImpl;

    @Autowired
    private EmailTemplateInterfaces emailTemplateService;

    @RequestMapping(value="/send", method = RequestMethod.POST,produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<String> sendEmail(@RequestBody EmailSendDTO emailSend ){
        EmailTemplate template = emailTemplateService.findByCode(emailSend.getCode());
        EmailDTO emailDto = new EmailDTO();
        emailDto.setDestinationEmail(emailSend.getDestinationEmail());
        emailDto.setHeader(template.getHeader());
        emailDto.setContent(template.getContent());
        emailServiceImpl.sendEmailTo(emailDto);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

}