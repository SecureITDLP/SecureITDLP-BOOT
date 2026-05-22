package com.velox.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;

@RestController
@RequestMapping("/test")
public class TestController {
	 
    // Hit this with: GET /api/hello  + Authorization: Bearer <token>
    @GetMapping("/hello")
    public ResponseEntity<?> hello(@AuthenticationPrincipal UserDetails user) {
        return ResponseEntity.ok(Map.of(
            "message", "Hello, " + user.getUsername() + "! JWT is working.",
            "roles", user.getAuthorities().toString()
        ));
    }
 
    // Another example protected endpoint
    @GetMapping("/dashboard")
    public ResponseEntity<?> dashboard(@AuthenticationPrincipal UserDetails user) {
        return ResponseEntity.ok(Map.of(
            "message", "Welcome to SecureIT-DLP dashboard",
            "user", user.getUsername()
        ));
    }
}