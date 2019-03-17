package com.pluto.aplication.service.interfaces;

import com.pluto.aplication.model.dto.EmailDTO;

public interface EmailServiceInterfaces{

    boolean sendEmailTo(EmailDTO email);

}