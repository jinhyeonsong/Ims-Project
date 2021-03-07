package org.bmj.ims.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.bmj.ims.vo.Idol;
import org.bmj.ims.vo.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class IdolsDAOImpl implements IdolsDAO{
	
	@Autowired
	private SqlSession session;
	
	@Override
	public int update(Idol idol) {
		return session.update("idols.update",idol);
	}
	
	@Override
	public List<Idol> selectList(PageVO pageVO) {
		return session.selectList("idols.selectList",pageVO);
	}
	
	@Override
	public int delete(int idolId) {
		return session.delete("idols.delete",idolId);
	}

	@Override
	public int selectTotal() {
		return session.selectOne("idols.selectTotal");
	}
	
	@Override
	public List<Idol> selectIdolList(int groupId) {
		return session.selectList("idols.selectIdolList",groupId);
	}

	@Override
	public Idol selectOne(Map<String, Object> map) {
		return session.selectOne("idols.selectOneMyLike",map);
	}
	
	@Override
	public Idol selectOne(int idolId) {
		return session.selectOne("idols.selectOne",idolId);
	}
	
	@Override
	public int insert(Idol idol) {
		return session.insert("idols.insert",idol);
	}
	
	@Override
	public int updateLikeCount(int idolId) {
		return session.update("idols.updateLikeCount",idolId);
	}
	
}










