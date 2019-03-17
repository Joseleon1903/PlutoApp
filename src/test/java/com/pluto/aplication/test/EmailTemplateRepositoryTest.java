package com.pluto.aplication.test;

import org.springframework.util.Assert;
import com.pluto.aplication.model.entity.EmailTemplate;
import com.pluto.aplication.repository.EmailTemplateRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmailTemplateRepositoryTest{

    @Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private EmailTemplateRepository emailTemplateRepository;

    String text = "Email_new_registration";

    @Before
    public void setUpTestEnviroment(){
        EmailTemplate  eTemplate = new EmailTemplate();
        eTemplate.setCode("Email_new_registration");
        eTemplate.setHeader("Welcome thanks for your registration");
        eTemplate.setContent("The welcome email one of the worlds leading aplication, "
        +"is quite discreet. This type of email isn’t usually recommended, as there is very little hook to the message.");
        emailTemplateRepository.save(eTemplate);
        entityManager.flush();
    }

    @Test
    public void emailTemplateFindbyCodeTest() {
        EmailTemplate found = emailTemplateRepository.findByCode(text);
        Assert.notNull(found, "Error user not found");
    }

}