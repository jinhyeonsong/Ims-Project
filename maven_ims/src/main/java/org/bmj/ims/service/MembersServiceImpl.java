package org.bmj.ims.service;

import org.bmj.ims.dao.MembersDAO;
import org.bmj.ims.vo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MembersServiceImpl implements MembersService{
	
	@Autowired
	private MembersDAO membersDAO;
	
	@Override
	public Member login(Member member) {
		return membersDAO.selectLogin(member);
	}
	
	@Override
	public boolean checkId(String id) {
		return 1==membersDAO.selectCheckId(id);
	}
	
	@Override
	public boolean checkNickname(String nickname) {
		return 1==membersDAO.selectNickname(nickname);
	}
}
