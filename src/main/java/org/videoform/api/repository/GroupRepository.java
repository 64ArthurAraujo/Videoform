package org.videoform.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.videoform.database.entity.Group;

public interface GroupRepository extends CrudRepository<Group, Long> {
	
}
