package com.pluto.aplication.test;

import org.springframework.util.Assert;
import com.pluto.aplication.constant.UtilityAplication;
import com.pluto.aplication.model.entity.Provided;
import com.pluto.aplication.repository.ProviderRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProviderRepositoryTest{

    @Autowired
    private ProviderRepository providerRepository;

    String name= "RSC";
    long id = 1;

    @Before
    public void initSetUp(){
        Provided prov = new Provided();
        prov.setId(id);
        prov.setName(name);
        prov.setAddress("calle primera N.5");
        prov.setEmail("rsccompany@gmail.com");
        prov.setPhone("8095647383");
        prov.setIsValidEmail(true);
        providerRepository.save(prov);
    }

    @Test
    public void findAllTest(){
        Page<Provided> foundpage = providerRepository.findAll(UtilityAplication.createPageableDefault());
        Assert.notEmpty(foundpage.getContent(), "Error Provided not found");
    }


    @Test
    public void findByTextTest(){
        Page<Provided> foundpage = providerRepository.findByNameContainingIgnoreCase(name,UtilityAplication.createPageableDefault());
        Assert.notEmpty(foundpage.getContent(), "Error Provided not found");
    }

    /*
    @Test
    public void findByIdTest(){
        Provided found = providerRepository.findById(id);
        Assert.notNull(found, "Error Provided not found");
    }
    */



}