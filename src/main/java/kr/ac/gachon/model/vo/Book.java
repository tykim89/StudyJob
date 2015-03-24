package kr.ac.gachon.model.vo;


public class Book {

	private int bookNo;
	private String memberId;
	private String tradeCategory;
	private String bookCategory;
	private String bookTitle;
	private String bookContentDate;
	private String bookContent;
	
	public Book(int bookNo, String memberId, String tradeCategory,
			String bookCategory, String bookTitle, String bookContentDate,
			String bookContent) {
		super();
		this.bookNo = bookNo;
		this.memberId = memberId;
		this.tradeCategory = tradeCategory;
		this.bookCategory = bookCategory;
		this.bookTitle = bookTitle;
		this.bookContentDate = bookContentDate;
		this.bookContent = bookContent;
	}
	
	
	public Book(String memberId, String tradeCategory, String bookCategory,
			String bookTitle, String bookContentDate, String bookContent) {
		super();
		this.memberId = memberId;
		this.tradeCategory = tradeCategory;
		this.bookCategory = bookCategory;
		this.bookTitle = bookTitle;
		this.bookContentDate = bookContentDate;
		this.bookContent = bookContent;
	}


	public Book(int bookNo, String memberId, String tradeCategory,
			String bookCategory, String bookTitle, String bookContent) {
		super();
		this.bookNo = bookNo;
		this.memberId = memberId;
		this.tradeCategory = tradeCategory;
		this.bookCategory = bookCategory;
		this.bookTitle = bookTitle;
		this.bookContent = bookContent;
	}



	public Book(int bookNo, String tradeCategory, String bookCategory,
			String bookTitle, String bookContent) {
		super();
		this.bookNo = bookNo;
		this.tradeCategory = tradeCategory;
		this.bookCategory = bookCategory;
		this.bookTitle = bookTitle;
		this.bookContent = bookContent;
	}
	

	public Book(String memberId, String tradeCategory, String bookCategory,
			String bookTitle, String bookContent) {
		super();
		this.memberId = memberId;
		this.tradeCategory = tradeCategory;
		this.bookCategory = bookCategory;
		this.bookTitle = bookTitle;
		this.bookContent = bookContent;
	}

	

	public Book(String tradeCategory, String bookCategory, String bookTitle,
			String bookContent) {
		super();
		this.tradeCategory = tradeCategory;
		this.bookCategory = bookCategory;
		this.bookTitle = bookTitle;
		this.bookContent = bookContent;
	}


	public Book(int bookNo) {
		super();
		this.bookNo = bookNo;
	}


	public Book() {
		super();
	}

	public int getbookNo() {
		return bookNo;
	}

	public void setbookNo(int bookNo) {
		this.bookNo = bookNo;
	}

	public String getmemberId() {
		return memberId;
	}

	public void setmemberId(String memberId) {
		this.memberId = memberId;
	}

	public String gettradeCategory() {
		return tradeCategory;
	}

	public void settradeCategory(String tradeCategory) {
		this.tradeCategory = tradeCategory;
	}

	public String getbookCategory() {
		return bookCategory;
	}

	public void setbookCategory(String bookCategory) {
		this.bookCategory = bookCategory;
	}

	public String getbookTitle() {
		return bookTitle;
	}

	public void setbookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getbookContentDate() {
		return bookContentDate;
	}

	public void setbookContentDate(String bookContentDate) {
		this.bookContentDate = bookContentDate;
	}

	public String getbookContent() {
		return bookContent;
	}

	public void setbookContent(String bookContent) {
		this.bookContent = bookContent;
	}

	@Override
	public String toString() {
		return "Book [bookNo=" + bookNo + ", memberId=" + memberId
				+ ", tradeCategory=" + tradeCategory + ", bookCategory="
				+ bookCategory + ", bookTitle=" + bookTitle
				+ ", bookContentDate=" + bookContentDate
				+ ", bookContent=" + bookContent + "]";
	}
	
	
}
