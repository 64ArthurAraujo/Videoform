package org.videoform.api.request;

import org.videoform.api.json.JsonRequest;
import org.videoform.database.entity.*;

public class UserCategoryJsonRequest implements JsonRequest<UserCategory> {
	public String categoryName;
	public String userToken;
	
	@Override
	public UserCategory convertJsonToEntity() {
		UserCategory newUserCategoryRelation = new UserCategory();
		
		newUserCategoryRelation.setCategoryName(categoryName);
		newUserCategoryRelation.setUserToken(userToken);
		newUserCategoryRelation.setInterestRate(1);
		
		return newUserCategoryRelation;
	}
}
