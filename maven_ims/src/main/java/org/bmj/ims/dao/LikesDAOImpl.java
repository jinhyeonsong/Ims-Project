package org.bmj.ims.dao;

import org.apache.ibatis.session.SqlSession;
import org.bmj.ims.vo.Like;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LikesDAOImpl implements LikesDAO {
	
	@Autowired
	private SqlSession session;
	
	@Override
	public Integer selectNo(Like like) {
		return session.selectOne("likes.selectNo",like);
	}
	@Override
	public int delete(int no) {
		return session.delete("likes.delete",no);
	}
	
	@Override
	public int insert(Like like) {
		return session.insert("likes.insert",like);
	}

}





