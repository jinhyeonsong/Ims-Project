package org.bmj.ims.service;

import java.util.Map;

import org.bmj.ims.vo.Group;

public interface GroupsService {
	
	public Map<String, Object> getGroups(int page);
	public boolean deleteGroup(int groupId);
	public int registerGroup(Group group);
	public Map<String, Object> getGroupDetail(int groupId);
	public Group getGroup(int groupId);
	public void modify(Group group);
	
}





