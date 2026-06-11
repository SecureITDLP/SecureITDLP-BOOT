package com.velox.service;

import org.springframework.http.ResponseEntity;

import com.velox.dto.LoginRequest;
import com.velox.model.LoginEntity;

public interface AuthService {

	//public Object login(LoginRequest request);
	
	public Object SignUp(LoginEntity LoginEntity);

	public LoginEntity authenticateAndGetUser(LoginRequest request);
	
}
