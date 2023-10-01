package com.codename_vp.serverside.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codename_vp.serverside.Component.JwtTokenUtil;
import com.codename_vp.serverside.Entity.AuthRequest;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthRequest authRequest) {
        // Authenticate the user (e.g., check credentials)
        // If authentication is successful, generate a JWT token
        String token = jwtTokenUtil.generateToken(authRequest.getUsername());
        return ResponseEntity.ok(token);
    }
}
