package org.videoform.api.controller.insert;

import static org.videoform.api.configuration.Settings.REQUEST_PATH_INSERT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.videoform.api.request.CategoryJsonRequest;
import org.videoform.api.response.CategoryJsonResponse;
import org.videoform.api.service.interf.ICategoryService;
import org.videoform.database.entity.Category;

@RestController
@RequestMapping(path = REQUEST_PATH_INSERT)
public class CategoryInsert {
	@Autowired
	private ICategoryService categoryService;
	
	@RequestMapping(method = RequestMethod.POST, path = "/categories/", consumes = "application/json")
	public ResponseEntity<CategoryJsonResponse> createCategory(@RequestBody CategoryJsonRequest jsonRequest) {
		Category newCreatedCategory = categoryService.insert(jsonRequest.convertJsonToEntity());
		
		return new ResponseEntity<>(new CategoryJsonResponse(newCreatedCategory), HttpStatus.CREATED);
	}
}
