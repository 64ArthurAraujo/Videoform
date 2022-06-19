package org.videoform.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.videoform.api.repository.CategoryRepository;
import org.videoform.api.service.interf.ICategoryService;
import org.videoform.database.entity.Category;

@Service
public class CategoryService implements ICategoryService {
	
	@Autowired
	private CategoryRepository repository;

	@Override
	public Category getById(Long id) {
		return repository.findById(id).get();
	}
	
	@Override
	public Category getByName(String name) {
		return repository.findByName(name);
	}

	@Override
	public Category insert(Category entity) {
		return repository.save(entity);
	}

	@Override
	public Iterable<Category> getAllCategories() {
		return repository.findAll();
	}
}
