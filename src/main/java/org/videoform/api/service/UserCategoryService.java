package org.videoform.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.videoform.api.repository.CategoryRepository;
import org.videoform.api.repository.UserCategoryRepository;
import org.videoform.api.repository.UserRepository;
import org.videoform.api.service.interf.IUserCategoryService;
import org.videoform.database.entity.Category;
import org.videoform.database.entity.User;
import org.videoform.database.entity.UserCategory;
import org.videoform.database.entity.util.CategorisedUserCategory;
import org.videoform.database.entity.util.ConvertedUserCategory;

@Service
public class UserCategoryService implements IUserCategoryService {
	
	@Autowired
	private UserCategoryRepository repository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserCategory getById(Long id) {
		return repository.findById(id).get();
	}
	
	public UserCategory getAlreadyCreatedUserCategoryRelation(UserCategory entity) {
		return repository.findById(getAlreadyCreatedCategory(entity).getId()).get();
	}

	@Override
	public ConvertedUserCategory insert(UserCategory entity) {
		if (categoryIsAlreadyCreated(entity)) {
			UserCategory existingUserCategoryRelation = getAlreadyCreatedUserCategoryRelation(entity);

			entity.setId(existingUserCategoryRelation.getId());
			entity.addInterest(1);
		} 
		
		return convertUserCategory(repository.save(entity));
	}

	private boolean categoryIsAlreadyCreated(UserCategory entity) {
		ConvertedUserCategory convertedEntity = convertUserCategory(entity);
		
		for (UserCategory categoryEntry : repository.findAll()) {
			ConvertedUserCategory convertedEntry = convertUserCategory(categoryEntry);
			
			if (convertedEntry.getIdCategory() == convertedEntity.getIdCategory() && 
				convertedEntry.getIdUser() == convertedEntity.getIdUser()) {
				return true;
			}
		}
		
		return false;
	}
	
	private UserCategory getAlreadyCreatedCategory(UserCategory entity) {
		ConvertedUserCategory convertedEntity = convertUserCategory(entity);
		
		for (UserCategory categoryEntry : repository.findAll()) {
			ConvertedUserCategory convertedEntry = convertUserCategory(categoryEntry);
			
			if (convertedEntry.getIdCategory() == convertedEntity.getIdCategory() && 
					convertedEntry.getIdUser() == convertedEntity.getIdUser()) {
				return categoryEntry;
			}
		}
		
		return null;
	}

	private ConvertedUserCategory convertUserCategory(UserCategory userCategory) {
		Category category = categoryRepository.findByName(userCategory.getCategoryName());
		User user = userRepository.findByAuthToken(userCategory.getUserToken());
		
		ConvertedUserCategory converted = new ConvertedUserCategory(
			userCategory.getId(), category.getId(),
			user.getId(), userCategory.getInterestRate()
		);
		
		return converted;
	}
	
	public CategorisedUserCategory convertToCategorisedUserCategory(UserCategory userCategory) {
		User user = userRepository.findByAuthToken(userCategory.getUserToken());
		
		CategorisedUserCategory converted = new CategorisedUserCategory(
			userCategory.getId(), userCategory.getCategoryName(),
			user.getUsername(), userCategory.getInterestRate()
		);
		
		return converted;
	}

	@Override
	public Iterable<UserCategory> listUserCategories(Long userId) {
		List<UserCategory> categoriesFromUser = new ArrayList<UserCategory>();
		
		for (UserCategory categoryEntry : repository.findAll()) {
			ConvertedUserCategory convertedCategoryEntry = convertUserCategory(categoryEntry);
			
			if (convertedCategoryEntry.getIdUser() == userId) {
				categoriesFromUser.add(categoryEntry);
			}
		}
		
		return categoriesFromUser;
	}
}
