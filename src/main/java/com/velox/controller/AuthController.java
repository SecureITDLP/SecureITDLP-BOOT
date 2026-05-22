package com.velox.controller;

import com.velox.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.velox.dto.LoginRequest;

import java.util.Map;

@RestController
@RequestMapping("/SecureIT/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin123";

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {

    	
        if (USERNAME.equals(request.getUsername())  && PASSWORD.equals(request.getPassword())) {

            String token = jwtUtil.generateToken(request.getUsername());
            return ResponseEntity.ok(Map.of("token", token, "username", request.getUsername(), "type", "Bearer"));
        }
        return ResponseEntity .status(HttpStatus.UNAUTHORIZED).body(Map.of("error", "Invalid username or password"));
    }
}