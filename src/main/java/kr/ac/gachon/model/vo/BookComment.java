package kr.ac.gachon.model.vo;


public class BookComment {

	private int commentNo;
	private int bookNo;
	private String commentDate;
	private String comm;
	private String memberId;
	
	public BookComment(int commentNo, int bookNo, String commentDate,
			String comm, String memberId) {
		super();
		this.commentNo = commentNo;
		this.bookNo = bookNo;
		this.commentDate = commentDate;
		this.comm = comm;
		this.memberId = memberId;
	}
	

	public BookComment(int bookNo, String commentDate, String comm,
			String memberId) {
		super();
		this.bookNo = bookNo;
		this.commentDate = commentDate;
		this.comm = comm;
		this.memberId = memberId;
	}
	

	public BookComment(int bookNo, String comm, String memberId) {
		super();
		this.bookNo = bookNo;
		this.comm = comm;
		this.memberId = memberId;
	}


	public BookComment(String comm, String memberId) {
		super();
		this.comm = comm;
		this.memberId = memberId;
	}


	public BookComment(int commentNo, String comm) {
		super();
		this.commentNo = commentNo;
		this.comm = comm;
	}
	

	public BookComment(int commentNo) {
		super();
		this.commentNo = commentNo;
	}


	public BookComment() {
		super();
	}

	public int getcommentNo() {
		return commentNo;
	}

	public void setcommentNo(int commentNo) {
		this.commentNo = commentNo;
	}

	public int getbookNo() {
		return bookNo;
	}

	public void setbookNo(int bookNo) {
		this.bookNo = bookNo;
	}

	public String getcommentDate() {
		return commentDate;
	}

	public void setcommentDate(String commentDate) {
		this.commentDate = commentDate;
	}

	public String getComm() {
		return comm;
	}

	public void setComm(String comm) {
		this.comm = comm;
	}

	public String getmemberId() {
		return memberId;
	}

	public void setmemberId(String memberId) {
		this.memberId = memberId;
	}

	@Override
	public String toString() {
		return "Book_Comment [commentNo=" + commentNo + ", bookNo="
				+ bookNo + ", commentDate=" + commentDate + ", comm=" + comm
				+ ", memberId=" + memberId + "]";
	}
	
	
}
