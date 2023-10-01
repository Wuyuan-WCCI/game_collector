package com.codename_vp.serverside.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codename_vp.serverside.Component.JwtTokenUtil;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class ApiController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @GetMapping("/secure-resource")
    public ResponseEntity<String> secureResource(@RequestHeader("Authorization") String token) {
        if (jwtTokenUtil.validateToken(token)) {
            // Token is valid; perform actions for secure resource
            return ResponseEntity.ok("Secure resource accessed");
        } else {
            // Token is invalid; return unauthorized response
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized");
        }
    }
}
