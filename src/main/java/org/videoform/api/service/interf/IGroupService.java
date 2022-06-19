package org.videoform.api.service.interf;

import org.videoform.database.entity.Group;

public interface IGroupService extends IService<Group, Group> {
	Iterable<Group> getAllGroups();
}
