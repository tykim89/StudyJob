package kr.ac.gachon.model.dao;

import java.util.List;

import kr.ac.gachon.model.vo.Member;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;

@Component("memberDAO")
public class MemberDAOImpl extends SqlSessionDaoSupport implements MemberDAO {

	public Member findMember(String member_id) {

		SqlSession session = getSqlSession();
		return session.selectOne("selectMemberById", member_id);
	}

	public Member findMember2(String member_id) {

		SqlSession session = getSqlSession();
		return session.selectOne("selectMemberById2", member_id);
	}

	public Member findMeberNamePhon(String member_id) {

		SqlSession session = getSqlSession();
		return session.selectOne("selectMeberNamePhone", member_id);
	}

	public List<Member> findMemberList() {

		SqlSession session = getSqlSession();
		return session.selectList("selectAllMember"); // id와 parameterType 입력한
														// 것.
	}

	public List<Member> getMemberList() {

		SqlSession session = getSqlSession();
		return session.selectList("selectMemberList");
	}

	public boolean create(Member member) {
		boolean flag = false;

		SqlSession session = getSqlSession();
		flag = session.insert("insertMember", member) > 0 ? true : false;

		return flag;

	}

	public boolean update(Member member) {
		boolean flag = false;

		SqlSession session = getSqlSession();
		flag = session.update("updateMember", member) > 0 ? true : false;

		return flag;
	}

	public boolean remove(String member_id) {
		boolean flag = false;

		SqlSession session = getSqlSession();
		flag = session.delete("delectMember", member_id) > 0 // id와
																// parameterType
																// 입력한 것.
		? true
				: false;

		return flag;
	}

	public boolean remove2(String member_id) {
		boolean flag = false;

		SqlSession session = getSqlSession();
		flag = session.delete("delectMember", member_id) > 0 // id와
																// parameterType
																// 입력한 것.
		? true
				: false;

		return flag;
	}

}
