package com.test.backend.service;

import com.test.backend.persistence.domain.backend.Plan;
import com.test.backend.persistence.domain.backend.User;
import com.test.backend.persistence.domain.backend.UserRole;
import com.test.backend.persistence.repositories.PlanRepository;
import com.test.backend.persistence.repositories.RoleRepository;
import com.test.backend.persistence.repositories.UserRepository;
import com.test.enums.PlanEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * Created by r0ot_h3x49 on 4/11/2017.
 */
@Service
@Transactional(readOnly = true)
public class UserService {
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PlanRepository planRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User createUser(User user, PlanEnum planEnum, Set<UserRole> userRoles){
        Plan plan = new Plan(planEnum);
        if(!planRepository.exists(planEnum.getId())){
            plan = planRepository.save(plan);
        }

        user.setPlan(plan);

        for (UserRole ur: userRoles){
            roleRepository.save(ur.getRole());
        }

        user.getUserRoles().addAll(userRoles);

        user = userRepository.save(user);

        return user;

    }

    public User findByUserName(String username ){
        return  userRepository.findByUsername(username);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
