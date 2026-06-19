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

	 private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

	 
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
				logger.info("Login Success");
				return ResponseEntity.ok(response);
			}catch(Exception ex) {
				
				ApiResponse<LoginResponse> response = new ApiResponse<>( false,"LOGIN_FAILED", ex.getMessage(), LocalDateTime.now() ,null);
				logger.error(ex.getMessage());
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