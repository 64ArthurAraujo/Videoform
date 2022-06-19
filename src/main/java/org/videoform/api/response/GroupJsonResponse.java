package org.videoform.api.response;

import org.videoform.database.entity.Group;

public class GroupJsonResponse {
	private Long id;
	private String name;
	
	public GroupJsonResponse(Group group) {
		this.id = group.getId();
		this.name = group.getName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
