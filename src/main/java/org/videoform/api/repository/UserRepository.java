package org.videoform.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.videoform.database.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	List<User> findByUsername(String username);
	User findByAuthToken(String auth_token);
}
