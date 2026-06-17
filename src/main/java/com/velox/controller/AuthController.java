package com.velox.controller;

import com.velox.utils.ApiResponse;
import com.velox.utils.JwtUtil;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.velox.dto.LoginRequest;
import com.velox.dto.LoginResponse;
import com.velox.dto.UserResponse;
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

	 private static final Logger logger =LoggerFactory.getLogger(AuthController.class);

//	@PostMapping("/login")
//	public ResponseEntity<Map<String, Object>> login(@RequestBody LoginRequest request) {
//		try {
//			
//			// Get authenticated user from service
//			LoginEntity user = AuthService.authenticateAndGetUser(request);
//			
//			// Generate token
//			String token = jwtUtil.generateToken(user.getUsername());
//
//			// Prepare response map
//			Map<String, Object> responseData = new HashMap<>();
//			responseData.put("accessToken", token);
//			responseData.put("refreshToken", null);
//			responseData.put("tokenType", "Bearer");
//			responseData.put("accessTokenExpirySeconds", 900);
//
//			// User object
//			Map<String, Object> userMap = new HashMap<>();
//			userMap.put("id", user.getId());
//			userMap.put("username", user.getUsername());
//			userMap.put("role", user.getAccount_status()); // Using account_status as role
//
//			responseData.put("user", userMap);
//			Map<String, Object> finalResponse = new HashMap<>();
//			finalResponse.put("data", responseData);
//			logger.info("Login Successful");
//			return new ResponseEntity<>(finalResponse, HttpStatus.OK);
//
//		} catch (Exception e) {
//			Map<String, Object> errorResponse = new HashMap<>();
//			errorResponse.put("message", "Error: " + e.getMessage());
//			errorResponse.put("data", null);
//			errorResponse.put("statusCode", 500);
//			logger.error("Failed to login");
//			return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
	 
		@PostMapping("/login")
		public ResponseEntity<ApiResponse<LoginResponse>> login(@RequestBody LoginRequest request) {
			try {
				LoginEntity user = AuthService.authenticateAndGetUser(request);
				String token = jwtUtil.generateToken(user.getUsername());
				
				UserResponse userResponse = new UserResponse();
				userResponse.setId(user.getId());
				userResponse.setUsername(user.getUsername());
				userResponse.setRole(user.getRole());
				
				LoginResponse loginResponse = new LoginResponse();
				loginResponse.setAccessToken(token);
				loginResponse.setRefreshToken(null);
				loginResponse.setTokenType("Bearer");
				loginResponse.setAccessTokenExpirySeconds(900);
				loginResponse.setUser(userResponse);
				
				ApiResponse<LoginResponse>response = new ApiResponse<>(true,"LOGIN_SUCCESS","Login successful", LocalDateTime.now(),loginResponse);
				return ResponseEntity.ok(response);
			}catch(Exception ex) {
				
				ApiResponse<LoginResponse> response =new ApiResponse<>( false,"LOGIN_FAILED", ex.getMessage(), LocalDateTime.now() ,null);
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
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