package com.velox.controller;

import java.util.HashMap;
import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

	@GetMapping("/hello")
	public ResponseEntity<?> hello(@AuthenticationPrincipal UserDetails user) {
		Map<String, Object> response = new HashMap<>();
		response.put("message", "Hello, " + user.getUsername() + "! JWT is working.");
		response.put("roles", user.getAuthorities().toString());
		return ResponseEntity.ok(response);
	}

	@GetMapping("/dashboard")
	public ResponseEntity<?> dashboard(@AuthenticationPrincipal UserDetails user) {
		Map<String, Object> response = new HashMap<>();
		response.put("message", "Welcome to SecureIT-DLP dashboard");
		response.put("user", user.getUsername());
		return ResponseEntity.ok(response);
	}
}