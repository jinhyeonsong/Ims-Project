package org.bmj.ims.dao;

import org.bmj.ims.vo.Like;

public interface LikesDAO {
	
	public Integer selectNo(Like like);
	public int insert(Like like);
	public int delete(int no);

}







