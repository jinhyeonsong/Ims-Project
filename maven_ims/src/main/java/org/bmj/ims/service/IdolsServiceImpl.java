package org.bmj.ims.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.bmj.ims.dao.GroupsDAO;
import org.bmj.ims.dao.IdolsDAO;
import org.bmj.ims.dao.LikesDAO;
import org.bmj.ims.util.PaginateUtil;
import org.bmj.ims.vo.Group;
import org.bmj.ims.vo.Idol;
import org.bmj.ims.vo.Like;
import org.bmj.ims.vo.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IdolsServiceImpl implements IdolsService{
	
	@Autowired
	private IdolsDAO idolsDAO;
	
	@Autowired
	private GroupsDAO groupsDAO;
	
	@Autowired
	private LikesDAO likesDAO;
	
	@Override
	public Map<String,Object> getIdols(int page) {
		
		Map<String, Object> map=new ConcurrentHashMap<String, Object>();
		
		int total=idolsDAO.selectTotal();
		
		PageVO pageVo=new PageVO(page,5);
		
		map.put("idols", idolsDAO.selectList(pageVo));
		map.put("paginate",PaginateUtil.getPaginate(page, total, 5, 3, "/idol"));
		
		return map;
	}
	
	@Override
	public int deleteIdol(int idolId) {
		return idolsDAO.delete(idolId);
	}
	
	@Override
	public Idol getIdol(int idolId, int memberNo) {
		
		Map<String, Object> map = 
				new ConcurrentHashMap<String, Object>();
		
		map.put("idolId", idolId);
		map.put("memberNo", memberNo);
		
		return idolsDAO.selectOne(map);
	}
	
	
	@Override
	public List<Group> getGroups() {
		return groupsDAO.selectGroupList();
	}
	
	@Override
	public void registerIdol(Idol idol) {
		idolsDAO.insert(idol);
	}
	
	@Override
	public Map<String, Object> getIdolUpdateForm(int idolId) {
		Map<String, Object> map = 
				new HashMap<String, Object>();
		
		map.put("idol",idolsDAO.selectOne(idolId));
		map.put("groups",groupsDAO.selectGroupList());
		
		return map;
	}
	
	
	@Override
	public void updateIdol(Idol idol) {
		idolsDAO.update(idol);
	}
	
	@Transactional
	@Override
	public void likeIdol(Like like) {
		
		Integer result = likesDAO.selectNo(like);
		//라이크를 눌렀는지 확인
		
		if(result!=null) {
			//라이크를 눌렀으면 삭제
			likesDAO.delete(result);
		}else {
			//라이크를 누르지 않았으면 입력
			likesDAO.insert(like);
		}//if~else end
		
		//idol테이블에 likeCount 업데이트
		idolsDAO.updateLikeCount(like.getTypeNo());
		
	}

}



