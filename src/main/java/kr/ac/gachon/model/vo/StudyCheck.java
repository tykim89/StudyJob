package kr.ac.gachon.model.vo;

public class StudyCheck {
	private int study_no;
	private String my_study_date;
	private String member_id;
	private String attendance_information;
	private int penalty;
	private String member_name;
	
	
	public StudyCheck(int study_no, String my_study_date, String member_id,
			String attendance_information, int penalty, String member_name) {
		super();
		this.study_no = study_no;
		this.my_study_date = my_study_date;
		this.member_id = member_id;
		this.attendance_information = attendance_information;
		this.penalty = penalty;
		this.member_name = member_name;
	}


	@Override
	public String toString() {
		return "StudyCheck [study_no=" + study_no + ", my_study_date="
				+ my_study_date + ", member_id=" + member_id
				+ ", attendance_information=" + attendance_information
				+ ", penalty=" + penalty + ", member_name=" + member_name + "]";
	}


	public int getStudy_no() {
		return study_no;
	}


	public void setStudy_no(int study_no) {
		this.study_no = study_no;
	}


	public String getMy_study_date() {
		return my_study_date;
	}


	public void setMy_study_date(String my_study_date) {
		this.my_study_date = my_study_date;
	}


	public String getMember_id() {
		return member_id;
	}


	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}


	public String getAttendance_information() {
		return attendance_information;
	}


	public void setAttendance_information(String attendance_information) {
		this.attendance_information = attendance_information;
	}


	public int getPenalty() {
		return penalty;
	}


	public void setPenalty(int penalty) {
		this.penalty = penalty;
	}


	public String getMember_name() {
		return member_name;
	}


	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}


	public StudyCheck() {
		super();
	}
	
	
	
	
	
	
	
	
	
	
}
