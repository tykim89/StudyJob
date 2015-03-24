package kr.ac.gachon.model.vo;

import java.util.List;

public class Member {
	private String member_id;
	private String member_name;
	private String social_security_number;
	private String password;
	private String phone_number;
	private String email;
	private String postal_number;
	private String address;
	private String profile;

	private List<Study> studyList;

	public Member(String member_id, String member_name,
			String social_security_number, String password,
			String phone_number, String email, String postal_number,
			String address, String profile) {
		super();
		this.member_id = member_id;
		this.member_name = member_name;
		this.social_security_number = social_security_number;
		this.password = password;
		this.phone_number = phone_number;
		this.email = email;
		this.postal_number = postal_number;
		this.address = address;
		this.profile = profile;
	}

	public Member() {
		super();
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public String getSocial_security_number() {
		return social_security_number;
	}

	public void setSocial_security_number(String social_security_number) {
		this.social_security_number = social_security_number;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPostal_number() {
		return postal_number;
	}

	public void setPostal_number(String postal_number) {
		this.postal_number = postal_number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public List<Study> getStudyList() {
		return studyList;
	}

	public void setStudyList(List<Study> studyList) {
		this.studyList = studyList;
	}

		
}
