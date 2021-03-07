package org.bmj.ims.vo;

import java.sql.Date;

public class Group {
	
	private int groupId,ownLike,likeCount;
	private String name;
	private Date debutDate;
	
	public Group() {
	}
	
	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}



	public int getOwnLike() {
		return ownLike;
	}

	public void setOwnLike(int ownLike) {
		this.ownLike = ownLike;
	}



	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDebutDate() {
		return debutDate;
	}

	public void setDebutDate(Date debutDate) {
		this.debutDate = debutDate;
	}
	
	

}
