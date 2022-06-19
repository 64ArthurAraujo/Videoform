package org.videoform.api.service.interf;

import org.videoform.database.entity.User;

public interface IUserService extends IService<User, User> {
	Iterable<User> getAllUsers();
	User getByToken(String authToken);
}



