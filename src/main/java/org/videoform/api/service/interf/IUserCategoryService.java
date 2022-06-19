package org.videoform.api.service.interf;

import org.videoform.database.entity.UserCategory;
import org.videoform.database.entity.util.CategorisedUserCategory;
import org.videoform.database.entity.util.ConvertedUserCategory;

public interface IUserCategoryService extends IService<UserCategory, ConvertedUserCategory> {
	Iterable<UserCategory> listUserCategories(Long userId);
	CategorisedUserCategory convertToCategorisedUserCategory(UserCategory userCategory);
}
