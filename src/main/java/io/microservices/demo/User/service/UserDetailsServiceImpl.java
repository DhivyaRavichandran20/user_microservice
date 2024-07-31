package io.microservices.demo.User.service;


import io.microservices.demo.User.model.User;
import io.microservices.demo.User.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl  {
    @Autowired
    UserRepository userRepository;


    @Transactional
    public User loadUserByUsername(String email)  {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User Not Found with username: " + email));
    }
}
