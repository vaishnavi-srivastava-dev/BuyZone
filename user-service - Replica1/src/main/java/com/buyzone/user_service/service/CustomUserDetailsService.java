package com.buyzone.user_service.service;

import com.buyzone.user_service.repository.UserRepository;
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
       if( username.contains("@")){
         //  System.out.println("inside load user using email");
           return userRepository.findByEmail(username).orElseThrow(() -> new RuntimeException("User doesn't exist: " + username));
       }
       // System.out.println("inside load user using username");
        return userRepository.findByPhone(username).orElseThrow(() -> new RuntimeException("User doesn't exist: " + username));
    }

}

