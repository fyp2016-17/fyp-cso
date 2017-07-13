package com.test;

import com.test.backend.persistence.domain.backend.Role;
import com.test.backend.persistence.domain.backend.User;
import com.test.backend.persistence.domain.backend.UserRole;
import com.test.backend.service.PlanService;
import com.test.backend.service.UserService;
import com.test.enums.PlanEnum;
import com.test.enums.RolesEnum;
import com.test.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class Application  implements CommandLineRunner {

	@Autowired
	private UserService userService;

    @Autowired
    private PlanService planService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
    public void run(String... args) throws Exception {

        planService.createPlan(PlanEnum.BASIC.getId());


	    User user = UserUtils.createUser();
        Set<UserRole> userRoles = new HashSet<>();
        userRoles.add(new UserRole(user, new Role(RolesEnum.BASIC)));
        System.out.println("[+] -- Creating user with username " + user.getUsername());
        userService.createUser(user, PlanEnum.PRO, userRoles);
        System.out.println("[+] -- Created User : " + user.getUsername());
    }
}
