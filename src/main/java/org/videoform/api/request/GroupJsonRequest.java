package org.videoform.api.request;

import org.videoform.api.json.JsonRequest;
import org.videoform.database.entity.Group;

public class GroupJsonRequest implements JsonRequest<Group> {
	public String name;
	
	@Override
	public Group convertJsonToEntity() {
		Group newGroup = new Group();
		
		newGroup.setName(this.name);
		
		return newGroup;
	}
}
