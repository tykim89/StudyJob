package kr.ac.gachon.model.service;

import java.util.List;

import kr.ac.gachon.model.dao.MemberDAO;
import kr.ac.gachon.model.vo.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("userService")
public class UserServiceImpl implements UserService {

	private MemberDAO memberDao;

	@Autowired
	public void setMemberDao(MemberDAO memberDao) {
		this.memberDao = memberDao;
	}

	public int login(String member_id, String password) {

		// id로 회원정보 조회
		Member member = memberDao.findMember2(member_id);

		// 조회결과 존재하지 않는다면 LOGIN_ID_FAIL
		if (member == null) {
			return LOGIN_ID_FAIL;
		} else {
			// 조회결과 존재한다면

			// 조회한 회원비밀번호와 매개변수 비밀번호가 일치하면 LOGIN_SUCCESS
			if (member.getPassword().equals(password)) {
				return LOGIN_SUCCESS;
			}

			// 조회한 회원비밀번호와 매개변수 비밀번호가 일치하지 않으면 LOGIN_PW_FAIL
			return LOGIN_PW_FAIL;

		}
	}

	public Member getUserById(String member_id) {
		return memberDao.findMember2(member_id);
	}

	public List<Member> getUserList() {
		return memberDao.findMemberList();
	}

	public void insert(String member_id, String member_name,
			String social_security_number, String password,
			String phone_number, String email, String postal_number,
			String address, String profile) {

		boolean flag = memberDao.create(new Member(member_id, member_name,
				social_security_number, password, phone_number, email,
				postal_number, address, profile));

		System.out.println("등록 : " + flag);

	}

	public void update(String member_id, String member_name,
			String social_security_number, String password,
			String phone_number, String email, String postal_number,
			String address, String profile) {

		boolean flag = memberDao.update(new Member(member_id, member_name,
				social_security_number, password, phone_number, email,
				postal_number, address, profile));

		System.out.println("수정 : " + flag);

	}

	public int remove(String member_id, String password) {

		if (!(password.equals(memberDao.findMember2(member_id).getPassword()))) {
			return DELETE_FAIL;
		} else {

			boolean flag = memberDao.remove(member_id);
			System.out.println("삭제 : " + flag);
			return DELETE_SUCCESS;
		}
	}

	public void remove2(String id) {
		boolean flag = memberDao.remove(id);
		System.out.println("삭제 :" + flag);
	}

}
