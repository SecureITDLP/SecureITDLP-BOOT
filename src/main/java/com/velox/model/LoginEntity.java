package com.velox.model;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Date;

// CHANGE: jakarta -> javax
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "login")
public class LoginEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String password;
	private String name;
	private String email;
	private String contact_no;
	private String account_status;

	private int failed_attempts;
	private String role;

	public LoginEntity() {
		super();
	}

	public LoginEntity(Long id, String username, String password, String name, String email, String contact_no,
			String account_status, int failed_attempts) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.contact_no = contact_no;
		this.account_status = account_status;
		this.failed_attempts = failed_attempts;
	}

	// getters & setters ...
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact_no() {
		return contact_no;
	}

	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}

	public String getAccount_status() {
		return account_status;
	}

	public void setAccount_status(String account_status) {
		this.account_status = account_status;
	}

	public int getFailed_attempts() {
		return failed_attempts;
	}

	public void setFailed_attempts(int failed_attempts) {
		this.failed_attempts = failed_attempts;
	}
}