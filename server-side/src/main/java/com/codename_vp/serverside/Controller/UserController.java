package com.codename_vp.serverside.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codename_vp.serverside.Entity.User;
import com.codename_vp.serverside.Service.UserService;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("user/id/{id}")
    public User getUserById(@PathVariable int id) {
        return this.userService.getUserById(id);
    }

    @GetMapping("user/username/{username}")
    public User getUserByUserName(@PathVariable String username) {
        return this.userService.getUserByUserName(username);
    }

    @GetMapping("user/users")
    public List<User> findUsers() {
        return this.userService.getAllUsers();
    }

}
