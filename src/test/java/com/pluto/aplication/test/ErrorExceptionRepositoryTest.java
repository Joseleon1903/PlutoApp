package com.pluto.aplication.test;

import org.springframework.util.Assert;
import java.util.List;
import com.pluto.aplication.model.entity.ErrorException;
import com.pluto.aplication.repository.ErrorExceptionRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ErrorExceptionRepositoryTest{

    @Autowired
    private ErrorExceptionRepository errorExceptionRepository;

    long code = 501;

    @Before
    public void initSetUp(){
        ErrorException errorE  = new ErrorException();
        errorE.setCode(code);
        errorE.setDescription("Check that you have used the correct email and password combination for the account you are trying to access.");
        errorE.setStatus(true);
        errorExceptionRepository.save(errorE);
    }

    @Test
    public void findByCodeTest(){
        ErrorException found = errorExceptionRepository.findByCode(code);
        Assert.notNull(found, "Error user not found");
    }

    @Test
    public void findAllActiveTest(){
        List<ErrorException> found = errorExceptionRepository.findAllActive();
        Assert.notEmpty(found, "Error user not found");
    }

}