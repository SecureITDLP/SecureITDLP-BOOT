package com.velox.serviceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.velox.model.LoginEntity;
import com.velox.repository.AuthRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private AuthRepository authRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		LoginEntity loginEntity = authRepository.findByUsername(username);

		if (loginEntity == null) {
			throw new UsernameNotFoundException("User not found: " + username);
		}

		// Build UserDetails WITHOUT any roles/authorities
		return User.builder().username(loginEntity.getUsername()).password(loginEntity.getPassword())
				.authorities(new ArrayList<>()) // empty authority list
				.build();
	}

}
