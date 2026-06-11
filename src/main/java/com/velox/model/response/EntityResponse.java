package com.velox.model.response;


public class EntityResponse {

	private Object response;
	private int status;
	

	public EntityResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public EntityResponse(Object response, int status) {
		super();
		this.response = response;
		this.status = status;
	}

	public Object getResponse() {
		return response;
	}
	public void setResponse(Object response) {
		this.response = response;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
