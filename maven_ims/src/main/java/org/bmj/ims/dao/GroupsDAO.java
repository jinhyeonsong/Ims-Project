package org.bmj.ims.dao;

import java.util.List;

import org.bmj.ims.vo.Group;
import org.bmj.ims.vo.PageVO;

public interface GroupsDAO {
	
	//페이징 처리 되어 있는 그룹 목록 메서드
	public List<Group> selectList(PageVO pageVO);
	//페이징 처리없이 그룹 전부인 메서드
	public List<Group> selectGroupList();
	//그룹을 삭제하는 메서드
	public int delete(int groupId);
	//그룹을 등록하는 메서드
	public int insert(Group group);
	//그룹의 전체크기를 얻어오는 메서드
	public int selectTotal();
	//한 개의 그룹을 얻어오는 메서드
	public Group selectDetail(int groupId);
	
	public int update(Group group);

}






