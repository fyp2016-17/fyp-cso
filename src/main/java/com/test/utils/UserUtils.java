package com.test.utils;

import com.test.backend.persistence.domain.backend.User;
import com.test.web.domain.BasicAccountPayload;

/**
 * Created by Abubakr on 4/11/2017.
 */
public class UserUtils {

    private UserUtils(){
        throw  new AssertionError("Cannot instantiate");
    }

    public static User createUser(){
        User user = new User();
        user.setUsername("basicUser");
        user.setPassword("secret");
        user.setEmail("basic@gmail.com");
        user.setFname("fname");
        user.setLname("lname");
        user.setCountry("PK");
        user.setPhoneNumber("03412781509");
        user.setEnabled(true);
        user.setDescription("a basic user");
        user.setProfileImageUrl("https://www.basic.com/basicuser");

        return user;
    }

    public static <T extends BasicAccountPayload> User fromWebUserToDomainUser(T frontendPayload){

        User user = new User();
        user.setUsername(frontendPayload.getUsername());
        user.setPassword(frontendPayload.getPassword());
        user.setFname(frontendPayload.getFirstName());
        user.setLname(frontendPayload.getLastName());
        user.setEmail(frontendPayload.getEmail());
        user.setPhoneNumber(frontendPayload.getPhoneNumber());
        user.setCountry(frontendPayload.getCountry());
        user.setEnabled(true);
        user.setDescription(frontendPayload.getDescription());

        return user;

    }
}
