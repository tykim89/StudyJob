package kr.ac.gachon.model.vo;

import java.util.Date;

public class StudyInfo {
	private String my_study_date;
	private int study_no;
	private String my_study_time;
	private String my_study_content;
	private String my_study_place;
	
	
	public StudyInfo(String my_study_date, int study_no, String my_study_time,
			String my_study_content, String my_study_place) {
		super();
		this.my_study_date = my_study_date;
		this.study_no = study_no;
		this.my_study_time = my_study_time;
		this.my_study_content = my_study_content;
		this.my_study_place = my_study_place;
	}


	public StudyInfo() {
		super();
	}


	public String getMy_study_date() {
		return my_study_date;
	}


	public void setMy_study_date(String my_study_date) {
		this.my_study_date = my_study_date;
	}


	public int getStudy_no() {
		return study_no;
	}


	public void setStudy_no(int study_no) {
		this.study_no = study_no;
	}


	public String getMy_study_time() {
		return my_study_time;
	}


	public void setMy_study_time(String my_study_time) {
		this.my_study_time = my_study_time;
	}


	public String getMy_study_content() {
		return my_study_content;
	}


	public void setMy_study_content(String my_study_content) {
		this.my_study_content = my_study_content;
	}


	public String getMy_study_place() {
		return my_study_place;
	}


	public void setMy_study_place(String my_study_place) {
		this.my_study_place = my_study_place;
	}


	@Override
	public String toString() {
		return "StudyInfo [my_study_date=" + my_study_date + ", study_no="
				+ study_no + ", my_study_time=" + my_study_time
				+ ", my_study_content=" + my_study_content
				+ ", my_study_place=" + my_study_place + "]";
	}
	
	
	
	
	
	
}
