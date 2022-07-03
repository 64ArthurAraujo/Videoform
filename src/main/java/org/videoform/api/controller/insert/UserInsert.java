package org.videoform.api.controller.insert;

import static org.videoform.api.configuration.Settings.REQUEST_PATH_INSERT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.videoform.api.request.*;
import org.videoform.api.response.*;
import org.videoform.api.service.interf.*;
import org.videoform.database.entity.*;
import org.videoform.database.entity.intermediary.ConvertedUserCategory;

@RestController
@RequestMapping(path = REQUEST_PATH_INSERT)
public class UserInsert {
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IUserCategoryService userCategoryService;
	
	@RequestMapping(method = RequestMethod.POST, path = "/users/", consumes = "application/json")
	public ResponseEntity<UserJsonResponse> insertUser(@RequestBody UserJsonRequest jsonRequest) {
		User newCreatedUser = userService.insert(jsonRequest.convertJsonToEntity());
		
		return new ResponseEntity<>(new UserJsonResponse(newCreatedUser), HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/users/categories/", consumes = "application/json") 
	public ResponseEntity<UserCategoryJsonResponse> createUser(@RequestBody UserCategoryJsonRequest jsonRequest) {
		ConvertedUserCategory newUserCategoryRelation = userCategoryService.insert(jsonRequest.convertJsonToEntity());	
		
		return new ResponseEntity<>(new UserCategoryJsonResponse(newUserCategoryRelation), HttpStatus.CREATED);
	}
}
