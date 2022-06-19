package org.videoform.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.videoform.api.repository.UserRepository;
import org.videoform.api.service.interf.IUserService;
import org.videoform.database.entity.User;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository repository;
	
	public UserService(UserRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public User getById(Long id) {
		return repository.findById(id).get();
	}
	
	@Override
	public User getByToken(String authToken) {
		return repository.findByAuthToken(authToken);
	}

	@Override
	public User insert(User entity) {
		return repository.save(entity);
	}

	@Override
	public Iterable<User> getAllUsers() {
		return repository.findAll();
	}

}
