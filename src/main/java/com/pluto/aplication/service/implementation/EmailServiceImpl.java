package com.pluto.aplication.service.implementation;

import com.pluto.aplication.model.dto.EmailDTO;
import com.pluto.aplication.service.interfaces.EmailServiceInterfaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailServiceInterfaces {

   @Autowired
   private JavaMailSender emailSender;
    
    @Override
    public boolean sendEmailTo(EmailDTO email) {
        SimpleMailMessage message = new SimpleMailMessage(); 
        message.setTo(email.getDestinationEmail()); 
        message.setSubject(email.getHeader()); 
        message.setText(email.getContent());
        emailSender.send(message);
        return true;
	}

}