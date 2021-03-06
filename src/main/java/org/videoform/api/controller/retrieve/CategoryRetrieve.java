package org.videoform.api.controller.retrieve;

import static org.videoform.api.configuration.Settings.REQUEST_PATH_RETRIEVE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.videoform.api.service.interf.ICategoryService;
import org.videoform.database.entity.Category;

@RestController
@RequestMapping(path = REQUEST_PATH_RETRIEVE)
public class CategoryRetrieve {
	@Autowired
	private ICategoryService categoryService;
	
	@RequestMapping(method = RequestMethod.GET, path = "/categories/")
	public ResponseEntity<Iterable<Category>> getCategories() {
		
		return new ResponseEntity<>(categoryService.getAllCategories(), HttpStatus.OK);
	}
}