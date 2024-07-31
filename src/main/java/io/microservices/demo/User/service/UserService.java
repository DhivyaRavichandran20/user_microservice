package io.microservices.demo.User.service;


import io.microservices.demo.User.model.LoginDTO;
import io.microservices.demo.User.model.User;
import io.microservices.demo.User.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    UserRepository userRepository;


    public String register(User user){
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            return "User with this email already exists";
        }
        userRepository.save(user);
        return "User Added Successfully";
    }


    public ResponseEntity<?> authenticate(LoginDTO login) {
        Optional<User> userDetails = userRepository.findByEmail(login.getEmail());
        if (userDetails.isPresent()) {
            User user = userDetails.get();
            if (user.getPassword().equals(login.getPassword())) {
                String token = "dummy-token";
                return ResponseEntity.ok(token);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
            }
        } else {
            return ResponseEntity.noContent().build();
        }
    }
}








