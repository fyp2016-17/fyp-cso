package com.test.test.intergration;

import com.test.backend.persistence.domain.backend.Plan;
import com.test.backend.persistence.domain.backend.Role;
import com.test.backend.persistence.domain.backend.User;
import com.test.backend.persistence.domain.backend.UserRole;
import com.test.backend.persistence.repositories.PlanRepository;
import com.test.backend.persistence.repositories.RoleRepository;
import com.test.backend.persistence.repositories.UserRepository;
import com.test.enums.PlanEnum;
import com.test.enums.RolesEnum;
import com.test.utils.UserUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Abubakr on 4/10/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RepositoriesIntegration {
    @Autowired
    private PlanRepository planRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;


   @Before
    public void init(){
       Assert.assertNotNull(planRepository);
       Assert.assertNotNull(roleRepository);
       Assert.assertNotNull(userRepository);
   }
//   Unit test for Plan Repository

   @Test
    public void testCreateNewPlan() throws Exception{
       Plan basicPlan = createPlan(PlanEnum.BASIC);
       planRepository.save(basicPlan);
       Plan retrievedPlan = planRepository.findOne(PlanEnum.BASIC.getId());
       Assert.assertNotNull(retrievedPlan);
   }

//    Unit Test for Role Repository

    @Test
    public void testCreateNewRole() throws Exception{
        Role basicRole = createRole(RolesEnum.BASIC);
        roleRepository.save(basicRole);
        Role retrievedRole = roleRepository.findOne(RolesEnum.BASIC.getId());
        System.out.println(retrievedRole);
        Assert.assertNotNull(retrievedRole);
    }

//    Unit Test for User Repository

    @Test
    public void testCreateNewUser() throws Exception {
        Plan basicPlan = createPlan(PlanEnum.BASIC);
        planRepository.save(basicPlan);

       User basicUser = UserUtils.createUser();
        basicUser.setPlan(basicPlan);

        Role basicRole = createRole(RolesEnum.BASIC);
        Set<UserRole> userRoles = new HashSet<>();
        UserRole userRole = new UserRole(basicUser, basicRole);
        userRoles.add(userRole);

        basicUser.getUserRoles().addAll(userRoles);

        for (UserRole ur: userRoles){
            roleRepository.save(ur.getRole());
        }

        basicUser = userRepository.save(basicUser);
        User newlyCreatedUser = userRepository.findOne(basicUser.getId());
        Assert.assertNotNull(newlyCreatedUser);
        Assert.assertTrue(newlyCreatedUser.getId() != 0);
        Assert.assertNotNull(newlyCreatedUser.getPlan());
        Assert.assertNotNull(newlyCreatedUser.getPlan().getId());

        Set<UserRole> newlyCreatedUserUserRoles = newlyCreatedUser.getUserRoles();
        for (UserRole ur: newlyCreatedUserUserRoles){
            Assert.assertNotNull(ur.getRole());
            Assert.assertNotNull(ur.getRole().getId());
        }
    }

    private Plan createPlan(PlanEnum planEnum){
        return new Plan(planEnum);
    }

    private Role createRole(RolesEnum rolesEnum){
        return new Role(rolesEnum);
    }


    private User createBasicUser(){
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
}
