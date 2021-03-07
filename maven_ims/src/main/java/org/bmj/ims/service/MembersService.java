package org.bmj.ims.service;

import org.bmj.ims.vo.Member;

public interface MembersService {
	
	public Member login(Member member);
	public boolean checkId(String id);
	public boolean checkNickname(String nickname);
}
