package com.pluto.aplication.test;

import org.springframework.util.Assert;
import com.pluto.aplication.model.entity.SystemUser;
import com.pluto.aplication.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest{

    @Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private UserRepository userRepository;

    String username = "test";

    @Before
    public void setUpTestEnviroment(){
        SystemUser alex = new SystemUser(username);
        entityManager.persist(alex);
        entityManager.flush();
    }

    @Test
    public void findByUsernameTest() {
        SystemUser found = userRepository.findByUsername(username);
        Assert.notNull(found, "Error user not found");
    }

    @Test
    public void updateUserTest() {
        SystemUser found = userRepository.findByUsername(username);
        found.setUsername("test2");
        userRepository.save(found);
        Assert.notNull(userRepository.findByUsername("test2"), "Error user not found");
    }


}