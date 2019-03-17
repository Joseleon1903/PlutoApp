package com.pluto.aplication.test;

import org.springframework.util.Assert;
import java.util.Date;
import java.util.List;
import com.pluto.aplication.model.entity.ItemType;
import com.pluto.aplication.repository.ItemTypeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ItemTypeRepositoryTest{

    @Autowired
    private ItemTypeRepository itemTypeRepository;

    long id = 1;
    String name = "test";

    @Before
    public void initSetUp(){
        ItemType itemType= new ItemType();
        //itemType.setId(id);
        itemType.setName(name);
        itemType.setDescription("Description of ");
        itemType.setCode("PTest");
        itemType.setCreationDate(new Date());
        itemType.setState(true);
        System.out.println("save entity: "+ itemType);
        itemTypeRepository.save(itemType);
    }

    @Test
    public void findByStateIsTrueTest(){
        List<ItemType> itemTypeF= itemTypeRepository.findByStateIsTrue();
        Assert.notEmpty(itemTypeF, "Error user not found");
    }

    @Test
    public void findAllTest(){
        List<ItemType> itemTypeF= itemTypeRepository.findAll();
        Assert.notEmpty(itemTypeF, "Error user not found");
    }

    /*
    @Test
    public void findByIdTest(){
        ItemType itemTypeF= itemTypeRepository.findById(id);
        Assert.notNull(itemTypeF, "Error user not found");
    }*/

}