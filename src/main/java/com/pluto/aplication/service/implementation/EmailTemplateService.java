package com.pluto.aplication.service.implementation;

import com.pluto.aplication.model.entity.EmailTemplate;
import com.pluto.aplication.repository.EmailTemplateRepository;
import com.pluto.aplication.service.interfaces.EmailTemplateInterfaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created by jleon on 6/22/2018.
 */
@Service
public class EmailTemplateService implements EmailTemplateInterfaces{

    @Autowired
    private EmailTemplateRepository emailTemplateRepository;

	@Override
	public EmailTemplate findByCode(String code) {
		return emailTemplateRepository.findByCode(code);
	}

	@Override
	public List<EmailTemplate> findAll() {
		return emailTemplateRepository.findAll();
	}

	@Override
	public EmailTemplate save(EmailTemplate emailTemplate) {

		long id = emailTemplateRepository.getNextSeriesId();
		return emailTemplateRepository.save(emailTemplate);
    }

}
