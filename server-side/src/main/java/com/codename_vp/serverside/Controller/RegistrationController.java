package com.codename_vp.serverside.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.codename_vp.serverside.Entity.User;
import com.codename_vp.serverside.Service.RegistrationService;

@RestController
@RequestMapping("/register")
public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;

    @PostMapping
    public ResponseEntity<User> registerUser(@RequestBody User newUser) {
        try {
            User user = registrationService.registerUser(newUser.getUserName(), newUser.getEmail(),
                    newUser.getPassword());
            return ResponseEntity.status(HttpStatus.CREATED).body(user);
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(e.getStatusCode()).build();
        }
    }
}
