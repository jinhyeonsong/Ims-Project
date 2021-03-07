package org.bmj.ims.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.bmj.ims.vo.Group;
import org.bmj.ims.vo.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GroupsDAOImpl implements GroupsDAO {
	
	@Autowired
	private SqlSession session;
	
	@Override
	public List<Group> selectList(PageVO pageVO) {
		return session.selectList("groups.selectList",pageVO);
	}
	
	@Override
	public int delete(int groupId) {
		System.out.println();
		return session.delete("groups.delete",groupId);
	}
	
	@Override
	public int insert(Group group) {
		return session.insert("groups.insert",group);
	}
	
	@Override
	public int selectTotal() {
		return session.selectOne("groups.selectTotal");
	}
	
	@Override
	public Group selectDetail(int groupId) {
		return session.selectOne("groups.selectDetail",groupId);
	}
	
	@Override
	public List<Group> selectGroupList() {
		return session.selectList("groups.selectGroupList");
	}
	
	@Override
	public int update(Group group) {
		return session.update("groups.update",group);
	}
	
}






