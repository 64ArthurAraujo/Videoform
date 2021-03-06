package org.videoform.api.controller.retrieve;

import static org.videoform.api.configuration.Settings.REQUEST_PATH_RETRIEVE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.videoform.api.service.interf.IGroupService;
import org.videoform.database.entity.Group;

@RestController
@RequestMapping(path = REQUEST_PATH_RETRIEVE)
public class GroupRetrieve {
	@Autowired
	private IGroupService groupService;
	
	@RequestMapping(method = RequestMethod.GET, path = "/groups/")
	public ResponseEntity<Iterable<Group>> getGroups() {
		
		return new ResponseEntity<>(groupService.getAllGroups(), HttpStatus.OK);
	}
}
