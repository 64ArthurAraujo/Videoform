package org.videoform.api.response;

import org.videoform.database.entity.User;

public class UserJsonResponse {
	private String username;
	private String password;
	private String authToken;
	
	public UserJsonResponse(User user) {
		this.username = user.getUsername();
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

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}
}
