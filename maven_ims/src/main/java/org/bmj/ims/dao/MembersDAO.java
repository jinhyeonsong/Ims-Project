package org.bmj.ims.dao;

import org.bmj.ims.vo.Member;

public interface MembersDAO {
	
	public Member selectLogin(Member member);

	public int selectCheckId(String id);

	public int selectNickname(String nickname);

}
