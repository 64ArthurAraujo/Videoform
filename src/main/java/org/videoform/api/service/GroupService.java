package org.videoform.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.videoform.api.repository.GroupRepository;
import org.videoform.api.service.interf.IGroupService;
import org.videoform.database.entity.Group;

@Service
public class GroupService implements IGroupService  {
	
	@Autowired
	private GroupRepository repository;
	
	public GroupService(GroupRepository repository) {
		this.repository = repository;
	}

	@Override
	public Group getById(Long id) {
		return repository.findById(id).get();
	}

	@Override
	public Group insert(Group entity) {
		return repository.save(entity);
	}

	@Override
	public Iterable<Group> getAllGroups() {
		return repository.findAll();
	}
}
