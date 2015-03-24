package kr.ac.gachon.model.service;

import java.util.List;

import kr.ac.gachon.model.vo.Member;

public interface UserService {

	public static final int LOGIN_SUCCESS = 1;
	public static final int LOGIN_ID_FAIL = 2;
	public static final int LOGIN_PW_FAIL = 3;

	public static final int DELETE_SUCCESS = 1;
	public static final int DELETE_FAIL = 2;

	public int login(String member_id, String password);

	public Member getUserById(String member_id);

	public List<Member> getUserList();

	public void insert(String member_id, String member_name,
			String social_security_number, String password,
			String phone_number, String email, String postal_number,
			String address, String profile);

	public void update(String member_id, String member_name,
			String social_security_number, String password,
			String phone_number, String email, String postal_number,
			String address, String profile);

	public int remove(String member_id, String password);

	public void remove2(String id);
}
