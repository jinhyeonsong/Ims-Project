package org.bmj.ims.vo;

public class PageVO {

	private int start,end, memberNo;
	
	public PageVO() {
	}
	
	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public PageVO(int page,int numPage) {
		this.end=page*numPage;
		this.start=end-numPage+1;
	}
	
	public PageVO(int page,int numPage,int memberNo) {
		this.end=page*numPage;
		this.start=end-numPage+1;
		this.memberNo = memberNo;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}
	
}
