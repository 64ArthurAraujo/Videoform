package org.videoform.api.service.interf;

import org.videoform.database.entity.Category;

public interface ICategoryService extends IService<Category, Category> {
	Iterable<Category> getAllCategories();
	Category getByName(String name);
}
