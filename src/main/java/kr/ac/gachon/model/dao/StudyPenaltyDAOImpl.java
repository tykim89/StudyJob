package kr.ac.gachon.model.dao;

import kr.ac.gachon.model.vo.StudyPenalty;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;

@Component("studyPenaltyDAO")
public class StudyPenaltyDAOImpl extends SqlSessionDaoSupport implements StudyPenaltyDAO  {

	
	public StudyPenalty findMoneyByNum(int study_no){
		
		SqlSession session = getSqlSession();
		return session.selectOne("selectMoneyByNum", study_no);
		
	}
	
	
	public boolean updateStudy_Penalty(StudyPenalty study_penalty){
	    boolean flag = false;
		SqlSession session = getSqlSession();
		flag = session.update("updateStudy_Penalty",study_penalty) > 0 ?true:false;
		return flag;
	}
	
	public boolean insertStudyPenalty(StudyPenalty study_penalty){
		boolean flag = false;
		SqlSession session = getSqlSession();
		flag = session.update("insertStudyPenalty",study_penalty) > 0 ?true:false;
		return flag;
	}
	
	
	
	
}
