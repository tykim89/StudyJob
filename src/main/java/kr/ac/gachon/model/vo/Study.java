package kr.ac.gachon.model.vo;


public class Study {
	private int study_no;
	private String study_category;
	private String study_area;
	private String study_rigion;
	private String study_week;
	private String study_time;
	private String study_title;
	private int study_number_of_person;
	private String study_content;
	private String period_start;
	private String period_end;
	private String member_id;
	private String study_content_date;

	
	public Study(int study_no, String study_category, String study_area,
			String study_rigion, String study_week, String study_time,
			String study_title, int study_number_of_person,
			String study_content, String period_start, String period_end,
			String member_id, String study_content_date) {
		super();
		this.study_no = study_no;
		this.study_category = study_category;
		this.study_area = study_area;
		this.study_rigion = study_rigion;
		this.study_week = study_week;
		this.study_time = study_time;
		this.study_title = study_title;
		this.study_number_of_person = study_number_of_person;
		this.study_content = study_content;
		this.period_start = period_start;
		this.period_end = period_end;
		this.member_id = member_id;
		this.study_content_date = study_content_date;
	}

	public Study(int study_no, String study_category, String study_area,
			String study_rigion, String study_time, String study_title,
			int study_number_of_person, String study_content,
			String period_start, String period_end, String member_id,
			String study_content_date) {
		super();
		this.study_no = study_no;
		this.study_category = study_category;
		this.study_area = study_area;
		this.study_rigion = study_rigion;
		this.study_time = study_time;
		this.study_title = study_title;
		this.study_number_of_person = study_number_of_person;
		this.study_content = study_content;
		this.period_start = period_start;
		this.period_end = period_end;
		this.member_id = member_id;
		this.study_content_date = study_content_date;
	}

	public Study(String study_category, String study_area, String study_rigion,
			String study_week, String study_time, String study_title,
			int study_number_of_person, String study_content,
			String period_start, String period_end, String member_id) {
		super();
		this.study_category = study_category;
		this.study_area = study_area;
		this.study_rigion = study_rigion;
		this.study_week = study_week;
		this.study_time = study_time;
		this.study_title = study_title;
		this.study_number_of_person = study_number_of_person;
		this.study_content = study_content;
		this.period_start = period_start;
		this.period_end = period_end;
		this.member_id = member_id;
	}

	
	
	public Study(String study_category, String study_area, String study_rigion,
			String study_week, String study_time, String study_title,
			int study_number_of_person, String study_content,
			String period_start, String period_end, String member_id,
			String study_content_date) {
		super();
		this.study_category = study_category;
		this.study_area = study_area;
		this.study_rigion = study_rigion;
		this.study_week = study_week;
		this.study_time = study_time;
		this.study_title = study_title;
		this.study_number_of_person = study_number_of_person;
		this.study_content = study_content;
		this.period_start = period_start;
		this.period_end = period_end;
		this.member_id = member_id;
		this.study_content_date = study_content_date;
	}

	public Study() {
		super();
	}

	public int getStudy_no() {
		return study_no;
	}

	public void setStudy_no(int study_no) {
		this.study_no = study_no;
	}

	public String getStudy_title() {
		return study_title;
	}

	public void setStudy_title(String study_title) {
		this.study_title = study_title;
	}

	public String getStudy_content_date() {
		return study_content_date;
	}

	public void setStudy_content_date(String study_content_date) {
		this.study_content_date = study_content_date;
	}

	public String getStudy_category() {
		return study_category;
	}

	public void setStudy_category(String study_category) {
		this.study_category = study_category;
	}

	public String getStudy_area() {
		return study_area;
	}

	public void setStudy_area(String study_area) {
		this.study_area = study_area;
	}

	public String getStudy_time() {
		return study_time;
	}

	public void setStudy_time(String study_time) {
		this.study_time = study_time;
	}

	public String getStudy_content() {
		return study_content;
	}

	public void setStudy_content(String study_content) {
		this.study_content = study_content;
	}

	public int getStudy_number_of_person() {
		return study_number_of_person;
	}

	public void setStudy_number_of_person(int study_number_of_person) {
		this.study_number_of_person = study_number_of_person;
	}

	public String getStudy_rigion() {
		return study_rigion;
	}

	public void setStudy_rigion(String study_rigion) {
		this.study_rigion = study_rigion;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getStudy_week() {
		return study_week;
	}

	public void setStudy_week(String study_week) {
		this.study_week = study_week;
	}

	public String getPeriod_start() {
		return period_start;
	}

	public void setPeriod_start(String period_start) {
		this.period_start = period_start;
	}

	public String getPeriod_end() {
		return period_end;
	}

	public void setPeriod_end(String period_end) {
		this.period_end = period_end;
	}
}
