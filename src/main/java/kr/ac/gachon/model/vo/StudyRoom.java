package kr.ac.gachon.model.vo;

public class StudyRoom {

	private int studyRoomNo;
	private String studyRoomCategory;
	private String studyRoomTitle;
	private String studyRoomImage;
	private String studyRoomContent;
	

	public StudyRoom(int studyRoomNo, String studyRoomCategory,
			String studyRoomTitle, String studyRoomImage,
			String studyRoomContent) {
		super();
		this.studyRoomNo = studyRoomNo;
		this.studyRoomCategory = studyRoomCategory;
		this.studyRoomTitle = studyRoomTitle;
		this.studyRoomImage = studyRoomImage;
		this.studyRoomContent = studyRoomContent;
	}


	public StudyRoom(String studyRoomCategory, String studyRoomTitle,
			String studyRoomImage, String studyRoomContent) {
		super();
		this.studyRoomCategory = studyRoomCategory;
		this.studyRoomTitle = studyRoomTitle;
		this.studyRoomImage = studyRoomImage;
		this.studyRoomContent = studyRoomContent;
	}


	public StudyRoom() {
		super();
	}

	public int getstudyRoomNo() {
		return studyRoomNo;
	}

	public void setstudyRoomNo(int studyRoomNo) {
		this.studyRoomNo = studyRoomNo;
	}

	public String getstudyRoomTitle() {
		return studyRoomTitle;
	}

	public void setstudyRoomTitle(String studyRoomTitle) {
		this.studyRoomTitle = studyRoomTitle;
	}

	public String getstudyRoomCategory() {
		return studyRoomCategory;
	}

	public void setstudyRoomCategory(String studyRoomCategory) {
		this.studyRoomCategory = studyRoomCategory;
	}

	public String getstudyRoomImage() {
		return studyRoomImage;
	}

	public void setstudyRoomImage(String studyRoomImage) {
		this.studyRoomImage = studyRoomImage;
	}

	public String getstudyRoomContent() {
		return studyRoomContent;
	}

	public void setstudyRoomContent(String studyRoomContent) {
		this.studyRoomContent = studyRoomContent;
	}


	@Override
	public String toString() {
		return "StudyRoom [studyRoomNo=" + studyRoomNo + ", studyRoomCategory="
				+ studyRoomCategory + ", studyRoomTitle=" + studyRoomTitle
				+ ", studyRoomImage=" + studyRoomImage + ", studyRoomContent="
				+ studyRoomContent + "]";
	}


	
}
