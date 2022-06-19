package org.videoform.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.videoform.database.entity.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
	Category findByName(String name);
}
