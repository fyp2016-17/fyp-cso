package com.test.test.unit;

import com.test.backend.persistence.domain.backend.User;
import com.test.utils.UserUtils;
import com.test.web.domain.BasicAccountPayload;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 * Created by Abubakr on 4/17/2017.
 */
public class UserUtilsUnitTest {

    private PodamFactory podamFactory;

    @Before
    public  void init(){
        podamFactory = new PodamFactoryImpl();

    }

    @Test
    public void mapWebUserToDomainUser(){
        BasicAccountPayload webUser = podamFactory.manufacturePojoWithFullData(BasicAccountPayload.class);
        webUser.setEmail("hussain1066@gmail.com ");

        User user = UserUtils.fromWebUserToDomainUser(webUser);
        Assert.assertNotNull(user);

        Assert.assertEquals(webUser.getUsername(), user.getUsername());
        Assert.assertEquals(webUser.getPassword(), user.getPassword());
        Assert.assertEquals(webUser.getFirstName(), user.getFname());
        Assert.assertEquals(webUser.getLastName(), user.getLname());
        Assert.assertEquals(webUser.getEmail(), user.getEmail());
        Assert.assertEquals(webUser.getPhoneNumber(), user.getPhoneNumber());
        Assert.assertEquals(webUser.getDescription(), user.getDescription());
        Assert.assertEquals(webUser.getCountry(), user.getCountry());

    }
}
