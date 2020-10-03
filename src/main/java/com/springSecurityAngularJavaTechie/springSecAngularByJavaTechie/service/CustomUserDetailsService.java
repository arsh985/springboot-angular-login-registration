package com.springSecurityAngularJavaTechie.springSecAngularByJavaTechie.service;

import com.springSecurityAngularJavaTechie.springSecAngularByJavaTechie.model.User;
import com.springSecurityAngularJavaTechie.springSecAngularByJavaTechie.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        CustomUserDetails userDetails = null;

        if (user !=null){
        userDetails = new CustomUserDetails();
        userDetails.setUser(user);
        }else{
            throw new UsernameNotFoundException("user not found with name: "+username);
        }


        return userDetails;
    }
}
