package kr.ac.gachon.model.vo;

public class Notice {
	
	private int noticeNo;
	private String noticeTitle;
	private String noticeContentDate;	
	private String noticeContent;
	private String noticeMainCategory;

	public Notice(String noticeTitle, String noticeContentDate,
			String noticeContent, String noticeMainCategory) {
		super();
		this.noticeTitle = noticeTitle;
		this.noticeContentDate = noticeContentDate;
		this.noticeContent = noticeContent;
		this.noticeMainCategory = noticeMainCategory;
	}
	
	public Notice() {
		super();
	}

	public Notice(int noticeNo, String noticeTitle, String noticeContentDate,
			String noticeContent, String noticeMainCategory) {
		super();
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.noticeContentDate = noticeContentDate;
		this.noticeContent = noticeContent;
		this.noticeMainCategory = noticeMainCategory;
	}
	
	public Notice(String noticeTitle, String noticeContent,
			String noticeMainCategory) {
		super();
		this.noticeMainCategory = noticeMainCategory;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;	
	}

	public Notice(int noticeNo, String noticeMainCategory, String noticeTitle,
			String noticeContent) {
		super();
		this.noticeNo = noticeNo;
		this.noticeMainCategory = noticeMainCategory;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
	}

	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeContentDate() {
		return noticeContentDate;
	}

	public void setNoticeContentDate(String noticeContentDate) {
		this.noticeContentDate = noticeContentDate;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public String getNoticeMainCategory() {
		return noticeMainCategory;
	}

	public void setNoticeMainCategory(String noticeMainCategory) {
		this.noticeMainCategory = noticeMainCategory;
	}
	
}