package org.videoform.api.request;

import org.videoform.api.json.JsonRequest;
import org.videoform.database.entity.User;
import org.videoform.logic.AuthToken;

public class UserJsonRequest implements JsonRequest<User> {
	public String username;
	public String password;
	
	@Override
	public User convertJsonToEntity() {
		User newUser = new User();
		
		newUser.setUsername(username);
		newUser.setPassword(password);
		newUser.setAuthToken(generateAuthToken());
		
		return newUser;
	}
	
	private String generateAuthToken() {
		return new AuthToken(22).getValue();
	}
}
