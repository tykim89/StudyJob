package kr.ac.gachon.model.vo;

public class MemberStudyParticipation {
	private String member_id;
	private Study study;
	
	
	public MemberStudyParticipation(String member_id, Study study) {
		super();
		this.member_id = member_id;
		this.study = study;
	}


	public MemberStudyParticipation() {
		super();
	}


	public String getMember_id() {
		return member_id;
	}


	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}


	public Study getStudy() {
		return study;
	}


	public void setStudy(Study study) {
		this.study = study;
	}


	@Override
	public String toString() {
		return "Member_Study_Participation [member_id=" + member_id
				+ ", study=" + study + "]";
	}

	
	
	
}
