package com.velox.model.response;

public class CustomEntityResponse {

	private String response;
	private int status;
	
	public CustomEntityResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomEntityResponse(String response, int status) {
		super();
		this.response = response;
		this.status = status;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
	
}
