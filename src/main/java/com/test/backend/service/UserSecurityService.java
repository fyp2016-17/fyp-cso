//package com.test.backend.service;
//
///**
// * Created by Abubakr on 4/18/2017.
// */
//public class UserSecurityService {
//}

package com.test.backend.service;

import com.test.backend.persistence.domain.backend.User;
import com.test.backend.persistence.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by tedonema on 31/03/2016.
 */
@Service
public class UserSecurityService implements UserDetailsService {

    /** The application logger */


    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (null == user) {
            throw new UsernameNotFoundException("Username " + username + " not found");
        }
        return user;
    }
}