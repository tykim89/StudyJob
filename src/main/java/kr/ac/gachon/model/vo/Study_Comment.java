package kr.ac.gachon.model.vo;

import java.util.Date;

public class Study_Comment {
	
	private int studyNo;
	private int commentNo;
	private String commentDate;
	private String comm;
	private String memberId;
	
	public int getStudyNo() {
		return studyNo;
	}
	public void setStudyNo(int studyNo) {
		this.studyNo = studyNo;
	}
	public int getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
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
		return "Study_Comment [studyNo=" + studyNo + ", commentNo=" + commentNo
				+ ", commentDate=" + commentDate + ", comm=" + comm
				+ ", memberId=" + memberId + "]";
	}

	public Study_Comment() {
		super();
	}

	
	
	public Study_Comment(int studyNo, int commentNo, String commentDate,
			String comm, String memberId) {
		super();
		this.studyNo = studyNo;
		this.commentNo = commentNo;
		this.commentDate = commentDate;
		this.comm = comm;
		this.memberId = memberId;
	}
	
	public Study_Comment(int studyNo, String commentDate, String comm,
			String memberId) {
		super();
		this.studyNo = studyNo;
		this.commentDate = commentDate;
		this.comm = comm;
		this.memberId = memberId;
	}
	public Study_Comment(int studyNo, String comm, String memberId) {
		super();
		this.studyNo = studyNo;
		this.comm = comm;
		this.memberId = memberId;
	}
	
	
	public Study_Comment(String comm, String memberId) {
		super();
		this.comm = comm;
		this.memberId = memberId;
	}
	
}
