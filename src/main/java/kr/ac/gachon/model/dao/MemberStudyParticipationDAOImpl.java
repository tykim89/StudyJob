	package kr.ac.gachon.model.dao;

import java.util.HashMap;
import java.util.List;

import kr.ac.gachon.model.vo.MemberStudyParticipation;
import kr.ac.gachon.model.vo.Study;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;

@Component("memberStudyParticipationDAO")
public class MemberStudyParticipationDAOImpl extends SqlSessionDaoSupport implements MemberStudyParticipationDAO {
	
	public List<Study> findParticipationListById(String member_id){
		SqlSession session = getSqlSession();
		return session.selectList("selectStudyParticipationListById", member_id);
	}
	
	public List<MemberStudyParticipation> findMemberStudyParticipation2(int study_no){
		SqlSession session = getSqlSession();
		return session.selectList("selectStudyByStudyNo", study_no);
	}

	public boolean removeMyStudy(String member_id, int study_no){
		boolean flag = false;
		SqlSession session = getSqlSession();
		HashMap<String, Object>map = new HashMap<String, Object>();
		map.put("member_id",member_id);
		map.put("study_no",study_no);
		flag = session.delete("removeMyStudy",map) > 0 ?true:false;
		return flag;
	}


	public int findByMemberCount(int study_no) {
		SqlSession session = getSqlSession();
		return session.selectOne("selectByMemberCount", study_no);
	}
	
	public boolean create(HashMap<String, Object> map) {
		boolean flag = false;
		SqlSession session = getSqlSession();
		flag = session.insert("insertParticipation", map) > 0 ? true : false;
		return flag;
	}
	
}
