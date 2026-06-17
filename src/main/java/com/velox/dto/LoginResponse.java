package com.velox.dto;


public class LoginResponse {

    private String accessToken;
    private String refreshToken;
    private String tokenType;
    private int accessTokenExpirySeconds;
    private UserResponse user;
    
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getRefreshToken() {
		return refreshToken;
	}
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	public String getTokenType() {
		return tokenType;
	}
	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}
	public int getAccessTokenExpirySeconds() {
		return accessTokenExpirySeconds;
	}
	public void setAccessTokenExpirySeconds(int accessTokenExpirySeconds) {
		this.accessTokenExpirySeconds = accessTokenExpirySeconds;
	}
	public UserResponse getUser() {
		return user;
	}
	public void setUser(UserResponse user) {
		this.user = user;
	}

    
}