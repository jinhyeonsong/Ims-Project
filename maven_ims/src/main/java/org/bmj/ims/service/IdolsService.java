package org.bmj.ims.service;

import java.util.List;
import java.util.Map;

import org.bmj.ims.vo.Group;
import org.bmj.ims.vo.Idol;
import org.bmj.ims.vo.Like;

public interface IdolsService {
	
	//아이돌 등록폼에서 그룹목록을 출력하는 메서드
	public List<Group> getGroups();
	//아이돌 목록을 위한 메서드(아이돌 목록, 페이징)
	public Map<String,Object> getIdols(int page);
	//아이돌 삭제하는 메서드
	public int deleteIdol(int idolId);
	
	//하나의 아이돌을 불러오는 메서드
	//public Idol getIdol(int idolId);
	public Idol getIdol(int idolId,int memberNo);
	
	//아이돌 등록 메서드
	public void registerIdol(Idol idol);
	
	//아이돌 수정폼에서 한개의 Idol객체와 
	//그룹목록을 맵으로 리턴하는 메서드
	public Map<String, Object> getIdolUpdateForm(int idolId);
	
	//아이돌을 수정하는 메서드
	public void updateIdol(Idol idol);
	
	//아이돌 like 버튼을 눌렀을때 작동되는 메서드
	public void likeIdol(Like like);

}





