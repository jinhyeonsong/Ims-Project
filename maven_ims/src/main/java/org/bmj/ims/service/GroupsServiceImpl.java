package org.bmj.ims.service;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.bmj.ims.dao.GroupsDAO;
import org.bmj.ims.dao.IdolsDAO;
import org.bmj.ims.util.PaginateUtil;
import org.bmj.ims.vo.Group;
import org.bmj.ims.vo.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupsServiceImpl implements GroupsService{
	
	@Autowired
	private GroupsDAO groupsDAO;
	
	@Autowired
	private IdolsDAO idolsDAO;
	
	@Override
	public Map<String,Object> getGroups(int page) {

		Map<String,Object> modelMap=new ConcurrentHashMap<String, Object>();
		
		PageVO pageVO=new PageVO(page,5);
	
		int total=groupsDAO.selectTotal();
		
		String paginate=PaginateUtil.getPaginate(
				page, total, 5, 3, "/group");
		
		modelMap.put("groupList", groupsDAO.selectList(pageVO));
		modelMap.put("paginate", paginate);
		
		return modelMap;
	}
	
	@Override
	public boolean deleteGroup(int groupId) {
		
		return 1== groupsDAO.delete(groupId);
	}
	
	@Override
	public int registerGroup(Group group) {
		return groupsDAO.insert(group);
	}

	@Override
	public Map<String, Object> getGroupDetail(int groupId) {
		
		Map<String, Object> map= new ConcurrentHashMap<String, Object>();
		
		map.put("group", groupsDAO.selectDetail(groupId));
		map.put("idols", idolsDAO.selectIdolList(groupId));
		
		return map;
	}
	
	@Override
	public Group getGroup(int groupId) {
		return groupsDAO.selectDetail(groupId);
	}
	
	@Override
	public void modify(Group group) {
		groupsDAO.update(group);
	}
}











