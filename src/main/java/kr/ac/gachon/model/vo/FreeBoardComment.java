package kr.ac.gachon.model.vo;


public class FreeBoardComment {
	private int commentNo;
	private int freeboardNo;
	private String commentDate;
	private String comm;
	private String memberId;
	
	public FreeBoardComment(int commentNo, int freeboardNo,
			String commentDate, String comm, String memberId) {
		super();
		this.commentNo = commentNo;
		this.freeboardNo = freeboardNo;
		this.commentDate = commentDate;
		this.comm = comm;
		this.memberId = memberId;
	}

	
	public FreeBoardComment(int freeboardNo, String commentDate, String comm,
			String memberId) {
		super();
		this.freeboardNo = freeboardNo;
		this.commentDate = commentDate;
		this.comm = comm;
		this.memberId = memberId;
	}


	public FreeBoardComment(int freeboardNo, String comm, String memberId) {
		super();
		this.freeboardNo = freeboardNo;
		this.comm = comm;
		this.memberId = memberId;
	}


	public FreeBoardComment() {
		super();
	}

	public int getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}

	public int getFreeboardNo() {
		return freeboardNo;
	}

	public void setFreeboardNo(int freeboardNo) {
		this.freeboardNo = freeboardNo;
	}

	public String getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}

	public String getComm() {
		return comm;
	}

	public void setComm(String comm) {
		this.comm = comm;
	}


	public String getMemberId() {
		return memberId;
	}


	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}


	@Override
	public String toString() {
		return "FreeBoard_Comment [commentNo=" + commentNo + ", freeboardNo="
				+ freeboardNo + ", commentDate=" + commentDate + ", comm="
				+ comm + ", memberId=" + memberId + "]";
	}

	
	
	
}
