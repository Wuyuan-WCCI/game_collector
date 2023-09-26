package com.codename_vp.serverside.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.codename_vp.serverside.Entity.User;
import com.codename_vp.serverside.Repository.UserRepo;

@Service
public class RegistrationService {
    @Autowired
    private UserRepo userRepo;

    public User registerUser(String userName, String email, String password) {
        if (userRepo.findByUserName(userName).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username already exists: " + userName);
        }

        User newUser = new User(userName, email, password);
        userRepo.save(newUser);

        return newUser;
    }
}
