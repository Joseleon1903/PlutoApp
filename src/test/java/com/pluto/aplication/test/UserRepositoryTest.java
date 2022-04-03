package com.pluto.aplication.test;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;
import com.pluto.aplication.model.entity.PlutoUser;
import com.pluto.aplication.repository.UserRepository;
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

    @Before("")
    public void setUpTestEnviroment(){
        PlutoUser alex = new PlutoUser(username);
        entityManager.persist(alex);
        entityManager.flush();
    }

    @Test
    public void findByUsernameTest() {
        PlutoUser found = userRepository.findByUsername(username);
        Assert.notNull(found, "Error user not found");
    }

    @Test
    public void updateUserTest() {
        PlutoUser found = userRepository.findByUsername(username);
        found.setUsername("test2");
        userRepository.save(found);
        Assert.notNull(userRepository.findByUsername("test2"), "Error user not found");
    }


}