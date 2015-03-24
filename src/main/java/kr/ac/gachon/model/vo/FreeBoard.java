package kr.ac.gachon.model.vo;



public class FreeBoard {
	private int freeboardNo;
	private String memberId;
	private String freeboardTitle;
	private String freeboardContentDate;
	private String freeboardContent;
	

	public FreeBoard(String memberId, String freeboardTitle,
			String freeboardContent) {
		super();
		this.memberId = memberId;
		this.freeboardTitle = freeboardTitle;
		this.freeboardContent = freeboardContent;
	}

	public FreeBoard(int freeboardNo, String memberId, String freeboardTitle,
			String freeboardContentDate, String freeboardContent) {
		super();
		this.freeboardNo = freeboardNo;
		this.memberId = memberId;
		this.freeboardTitle = freeboardTitle;
		this.freeboardContentDate = freeboardContentDate;
		this.freeboardContent = freeboardContent;
	}

	public FreeBoard(String memberId, String freeboardTitle,
			String freeboardContentDate, String freeboardContent) {
		super();
		this.memberId = memberId;
		this.freeboardTitle = freeboardTitle;
		this.freeboardContentDate = freeboardContentDate;
		this.freeboardContent = freeboardContent;
	}

	public FreeBoard(int freeboardNo, String freeboardTitle,
			String freeboardContentDate, String freeboardContent) {
		super();
		this.freeboardNo = freeboardNo;
		this.freeboardTitle = freeboardTitle;
		this.freeboardContentDate = freeboardContentDate;
		this.freeboardContent = freeboardContent;
	}

	public FreeBoard() {
		super();
	}

	public int getFreeboardNo() {
		return freeboardNo;
	}

	public void setFreeboardNo(int freeboardNo) {
		this.freeboardNo = freeboardNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getFreeboardTitle() {
		return freeboardTitle;
	}

	public void setFreeboardTitle(String freeboardTitle) {
		this.freeboardTitle = freeboardTitle;
	}

	public String getFreeboardContentDate() {
		return freeboardContentDate;
	}

	public void setFreeboardContentDate(String freeboardContentDate) {
		this.freeboardContentDate = freeboardContentDate;
	}

	public String getFreeboardContent() {
		return freeboardContent;
	}

	public void setFreeboardContent(String freeboardContent) {
		this.freeboardContent = freeboardContent;
	}

	@Override
	public String toString() {
		return "FreeBoard [freeboardNo=" + freeboardNo + ", memberId="
				+ memberId + ", freeboardTitle=" + freeboardTitle
				+ ", freeboardContentDate=" + freeboardContentDate
				+ ", freeboardContent=" + freeboardContent + "]";
	}
	
	
}
