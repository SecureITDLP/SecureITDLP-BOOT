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

		// Fetch and return user from DB
		LoginEntity loginEntity = AuthRepository.findByUsername(request.getUsername());

		if (loginEntity == null) {
			throw new RuntimeException("User not exist");
		}
		if ("BLOCKED".equals(loginEntity.getAccount_status())) {
			throw new RuntimeException("Account is blocked. Contact admin.");
		}

		if (!passwordEncoder.matches(request.getPassword(), loginEntity.getPassword())) {

			int attempts = loginEntity.getFailed_attempts() + 1;
			loginEntity.setFailed_attempts(attempts);

			if (attempts >= 3) {
				loginEntity.setAccount_status("BLOCKED");
				AuthRepository.save(loginEntity);
				throw new RuntimeException("Account blocked due to too many failed attempts.");
			}

			AuthRepository.save(loginEntity);
			throw new RuntimeException("Invalid credentials. " + (3 - attempts) + " attempt(s) remaining.");
		}

		if (loginEntity.getFailed_attempts() > 0) {
			loginEntity.setFailed_attempts(0);
			AuthRepository.save(loginEntity);
		}
		return loginEntity;
	}


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
