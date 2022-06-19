package org.videoform.api.request;

import org.videoform.api.json.JsonRequest;
import org.videoform.database.entity.Category;

public class CategoryJsonRequest implements JsonRequest<Category> {
	public String name;
	public Long groupId;
	
	@Override
	public Category convertJsonToEntity() {
		Category newCategory = new Category();
		
		newCategory.setName(this.name);
		newCategory.setGroupId(this.groupId);
		
		return newCategory;
	}
	
}
