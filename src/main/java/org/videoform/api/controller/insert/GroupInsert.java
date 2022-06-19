package org.videoform.api.controller.insert;

import static org.videoform.api.configuration.Settings.REQUEST_PATH_INSERT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.videoform.api.request.GroupJsonRequest;
import org.videoform.api.response.GroupJsonResponse;
import org.videoform.api.service.interf.IGroupService;
import org.videoform.database.entity.Group;

@RestController
@RequestMapping(path = REQUEST_PATH_INSERT)
public class GroupInsert {
	@Autowired
	private IGroupService groupService;
	
	@RequestMapping(method = RequestMethod.POST, path = "/groups/", consumes = "application/json")
	public ResponseEntity<GroupJsonResponse> createGroup(@RequestBody GroupJsonRequest jsonRequest) {
		Group newCreatedGroup = groupService.insert(jsonRequest.convertJsonToEntity());
		
		return new ResponseEntity<>(new GroupJsonResponse(newCreatedGroup), HttpStatus.CREATED);
	}
}
