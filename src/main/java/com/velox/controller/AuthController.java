package com.velox.controller;

import com.velox.utils.JwtUtil;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.velox.dto.LoginRequest;
import com.velox.model.LoginEntity;
import com.velox.model.response.CustomEntityResponse;
import com.velox.model.response.EntityResponse;
import com.velox.service.AuthService;


@RestController
@CrossOrigin("*")
@RequestMapping("/SecureIT/auth")
public class AuthController {

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private AuthService AuthService;

//	@PostMapping("/login")
//	public ResponseEntity<?> login(@RequestBody LoginRequest request) {
//
//		try {
//			Object response = AuthService.login(request);
//			return new ResponseEntity<>(new EntityResponse(response, 0), HttpStatus.OK);
//
//		} catch (Exception Ex) {
//			return new ResponseEntity<>(new CustomEntityResponse(Ex.getMessage(), -1), HttpStatus.BAD_REQUEST);
//		}
//
//	}

	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> login(@RequestBody LoginRequest request) {
		try {
			System.out.println("Inside login Controller");

			// Get authenticated user from service
			LoginEntity user = AuthService.authenticateAndGetUser(request);

			System.out.println("Logged in user: " + user.getUsername());

			// Generate token
			String token = jwtUtil.generateToken(user.getUsername());
//			System.out.println("token: " + token);

			// Prepare response map
			Map<String, Object> responseData = new HashMap<>();
			responseData.put("accessToken", token);
			responseData.put("refreshToken", null);
			responseData.put("tokenType", "Bearer");
			responseData.put("accessTokenExpirySeconds", 900);

			// User object
			Map<String, Object> userMap = new HashMap<>();
			userMap.put("id", user.getId());
			userMap.put("username", user.getUsername());
			userMap.put("role", user.getAccount_status()); // Using account_status as role

			responseData.put("user", userMap);

			// Create final response with message
			Map<String, Object> finalResponse = new HashMap<>();
			finalResponse.put("message", "Login Successful");
			finalResponse.put("data", responseData);
//			finalResponse.put("statusCode", 200);
			finalResponse.put("status", 200);

			return new ResponseEntity<>(finalResponse, HttpStatus.OK);

		} catch (Exception e) {
			Map<String, Object> errorResponse = new HashMap<>();
			errorResponse.put("message", "Error: " + e.getMessage());
			errorResponse.put("data", null);
			errorResponse.put("statusCode", 500);
			return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/SignUp")
	public ResponseEntity<?> SignUp(@RequestBody LoginEntity LoginEntity) {

		try {
			return new ResponseEntity<>(new EntityResponse(AuthService.SignUp(LoginEntity), 0), HttpStatus.OK);
		} catch (Exception Ex) {
			return new ResponseEntity<>(new CustomEntityResponse(Ex.getMessage(), -1), HttpStatus.BAD_REQUEST);
		}

	}

}