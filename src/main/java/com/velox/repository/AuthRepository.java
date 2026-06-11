package com.velox.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.velox.model.LoginEntity;

@Repository
public interface AuthRepository extends JpaRepository<LoginEntity, Long>  {

	 LoginEntity findByUsername(String username);

	 Boolean existsByUsername(String username);
	 
	
}

