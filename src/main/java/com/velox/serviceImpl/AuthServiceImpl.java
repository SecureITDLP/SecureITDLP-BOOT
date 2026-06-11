package com.velox.serviceImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.velox.dto.LoginRequest;
import com.velox.model.LoginEntity;
import com.velox.model.response.CustomEntityResponse;
import com.velox.repository.AuthRepository;
import com.velox.service.AuthService;
import com.velox.utils.JwtUtil;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	AuthRepository AuthRepository;

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public LoginEntity authenticateAndGetUser(LoginRequest request) {
		// Authenticate using AuthenticationManager
//		authenticationManager
//				.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

		// Fetch and return user from DB
		LoginEntity loginEntity = AuthRepository.findByUsername(request.getUsername());

		if (loginEntity == null) {
			throw new RuntimeException("User not found");
		}

		return loginEntity;
	}

//	public Object login(LoginRequest request) {
//
//		LoginEntity loginEntity = AuthRepository.findByUsername(request.getUsername());
//
//		if (loginEntity == null) {
//			return new CustomEntityResponse("User not Exist", -1);
//		}
//		boolean passwordMatch = passwordEncoder.matches(request.getPassword(), loginEntity.getPassword());
//
//		if (!passwordMatch) {
//			return new CustomEntityResponse("Invalid Password", -1);
//		}
//		String token = jwtUtil.generateToken(loginEntity.getUsername());
//		return Map.of("message", "Login Success", "token", token, "username", loginEntity.getUsername(), "type",
//				"Bearer");
//
//	}

	public Object SignUp(LoginEntity LoginEntity) {

		Boolean IsUSernamePresent = AuthRepository.existsByUsername(LoginEntity.getUsername());
		if (IsUSernamePresent) {
			System.out.println("Username already exist " + LoginEntity.getUsername());
			return "Username Exist";

		} else {
			String rawPassword = LoginEntity.getPassword();
			String encodedPassword = passwordEncoder.encode(rawPassword);

			LoginEntity.setPassword(encodedPassword);
			AuthRepository.save(LoginEntity);
			System.out.println("SignUp Success");
			return "User saved";
		}
	}

	

}
