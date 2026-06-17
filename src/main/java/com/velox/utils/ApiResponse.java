package com.velox.utils;

import java.time.LocalDateTime;

public class ApiResponse<T> {

	boolean success;
	String code;
	String message;
	LocalDateTime timestamp;
	T data;

	public ApiResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ApiResponse(boolean success, String code, String message, LocalDateTime timestamp, T data) {
		super();
		this.success = success;
		this.code = code;
		this.message = message;
		this.timestamp = timestamp;
		this.data = data;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
