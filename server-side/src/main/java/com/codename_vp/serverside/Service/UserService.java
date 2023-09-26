package com.codename_vp.serverside.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.codename_vp.serverside.Entity.User;
import com.codename_vp.serverside.Repository.UserRepo;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public void createUser(User user) {
        this.userRepo.save(user);
    }

    public User getUserById(int id) {
        return this.userRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found" + id));
    }

    public User getUserByUserName(String userName) {
        return this.userRepo.findByUserName(userName)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found" + userName));
    }

    public List<User> getAllUsers() {
        return this.userRepo.findAll();
    }
}
