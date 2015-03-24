package kr.ac.gachon.model.dao;

import java.util.List;

import kr.ac.gachon.model.vo.Member;

public interface MemberDAO {
	public Member findMember(String member_id);
	public Member findMember2(String member_id);
	public Member findMeberNamePhon(String member_id);
	public List<Member> findMemberList();
	public List<Member> getMemberList();
	
	public boolean create(Member member);
	public boolean update(Member member);
	public boolean remove(String member_id);
}
