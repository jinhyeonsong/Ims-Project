package org.bmj.ims.dao;

import org.apache.ibatis.session.SqlSession;
import org.bmj.ims.vo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MembersDAOImpl implements MembersDAO{

	@Autowired
	private SqlSession session;
	
	@Override
	public Member selectLogin(Member member) {
		return session.selectOne("members.selectLogin",member);
	}

	@Override
	public int selectCheckId(String id) {
		return session.selectOne("members.selectCheckId",id);
	}
	
	@Override
	public int selectNickname(String nickname) {
		return session.selectOne("members.selectNickname",nickname);
	}
}


