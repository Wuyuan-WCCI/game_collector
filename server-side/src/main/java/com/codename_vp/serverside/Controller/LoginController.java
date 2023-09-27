package com.codename_vp.serverside.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.codename_vp.serverside.Entity.User;
import com.codename_vp.serverside.Service.LoginService;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "http://localhost:5173")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping
    public ResponseEntity<User> loginUser(@RequestBody User user) {
        try {
            User loggedInUser = loginService.loginUser(user.getUserName(), user.getPassword());
            return ResponseEntity.ok(loggedInUser);
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(e.getStatusCode()).build();
        }
    }
}
