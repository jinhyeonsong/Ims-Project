package org.bmj.ims.dao;

import java.util.List;
import java.util.Map;

import org.bmj.ims.vo.Idol;
import org.bmj.ims.vo.PageVO;

public interface IdolsDAO {
	
	public List<Idol> selectList(PageVO pageVO);
	
	public int delete(int idolId);
	
	public int selectTotal();
	
	public List<Idol> selectIdolList(int groupId);
	
	public Idol selectOne(int idolId);
	
	public Idol selectOne(Map<String, Object> map);
	
	public int insert(Idol idol);
	
	public int update(Idol idol);
	
	public int updateLikeCount(int idolId);

}





