package com.test.test.intergration;

import com.test.backend.persistence.domain.backend.Role;
import com.test.backend.persistence.domain.backend.User;
import com.test.backend.persistence.domain.backend.UserRole;
import com.test.backend.service.UserService;
import com.test.enums.PlanEnum;
import com.test.enums.RolesEnum;
import com.test.utils.UserUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by r0ot_h3x49 on 4/11/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceIntegration {

    @Autowired
    private UserService userService;

    @Test
    public void testCreateNewUser() throws Exception {
        Set<UserRole> userRoles = new HashSet<>();
        User basicUser = UserUtils.createUser();
        userRoles.add(new UserRole(basicUser, new Role(RolesEnum.BASIC)));

        User user = userService.createUser(basicUser, PlanEnum.BASIC, userRoles);
        Assert.assertNotNull(user);
        Assert.assertNotNull(user.getId());
    }
}
