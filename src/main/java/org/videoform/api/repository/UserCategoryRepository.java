package org.videoform.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.videoform.database.entity.UserCategory;

public interface UserCategoryRepository extends CrudRepository<UserCategory, Long> {

}
