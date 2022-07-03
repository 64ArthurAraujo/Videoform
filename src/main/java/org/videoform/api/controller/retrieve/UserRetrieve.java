package org.videoform.api.controller.retrieve;

import static org.videoform.api.configuration.Settings.REQUEST_PATH_RETRIEVE;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.videoform.api.service.interf.IUserCategoryService;
import org.videoform.api.service.interf.IUserService;
import org.videoform.database.entity.User;
import org.videoform.database.entity.UserCategory;
import org.videoform.database.entity.intermediary.CategorisedUserCategory;

@RestController
@RequestMapping(path = REQUEST_PATH_RETRIEVE)
public class UserRetrieve {
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IUserCategoryService userCategoryService;
	
	@RequestMapping(method = RequestMethod.GET, path = "/users/")
	public ResponseEntity<Iterable<User>> getUsers() {
		
		return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") @NotNull Long id) {
		
		return new ResponseEntity<>(userService.getById(id), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/users/{id}/interest/total")
	public ResponseEntity<Integer> getUserTotalInterest(@PathVariable("id") @NotNull Long id) {
		int interestAmount = 0;
		
		for (UserCategory entry : userCategoryService.listUserCategories(id)) {
			interestAmount += entry.getInterestRate();
		}
		
		return new ResponseEntity<>(interestAmount, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/users/{id}/interest/categorised")
	public ResponseEntity<List<CategorisedUserCategory>> getCategorisedInterests(@PathVariable("id") @NotNull Long id) {
		List<CategorisedUserCategory> interestCategories = new ArrayList<>();
		
		for (UserCategory entry : userCategoryService.listUserCategories(id)) {
			interestCategories.add(userCategoryService.convertToCategorisedUserCategory(entry));
		}
		
		return new ResponseEntity<>(interestCategories, HttpStatus.OK);
	}
}
