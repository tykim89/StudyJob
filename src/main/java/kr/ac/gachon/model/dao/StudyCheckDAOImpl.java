package kr.ac.gachon.model.dao;

import java.util.HashMap;

import kr.ac.gachon.model.vo.StudyCheck;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;

@Component("studyCheckDAO")
public class StudyCheckDAOImpl extends SqlSessionDaoSupport implements StudyCheckDAO  {


	//출석, 지각 체크 및 벌금 입력받기
	public boolean updateStudyAttendanceCheck(StudyCheck study_check){
	    boolean flag = false;
		SqlSession session = getSqlSession();
		flag = session.update("updateStudyAttendanceCheck",study_check) > 0 ?true:false;
		return flag;
	}
	
	
	public boolean updatePenalty(StudyCheck study_check){
	    boolean flag = false;
		SqlSession session = getSqlSession();
		flag = session.update("updatePenalty",study_check) > 0 ?true:false;
		return flag;
	}
	
	
public int findAttendanceCount(String attendance_information, String member_id, int study_no){
		
	
		SqlSession session = getSqlSession();
		HashMap<String, Object>map = new HashMap<String, Object>();
		map.put("attendance_information",attendance_information);
		map.put("member_id",member_id);
		map.put("study_no", study_no);
		return session.selectOne("selectAttendanceCount", map);
	
	}
	

public int findSumPenalty(String member_id, int study_no){
	
	
	SqlSession session = getSqlSession();
	HashMap<String, Object>map = new HashMap<String, Object>();
	map.put("member_id",member_id);
	map.put("study_no", study_no);
	return session.selectOne("selectSumPenalty", map);
	
}

public boolean createMyStudyCheck(StudyCheck study_check){
    boolean flag = false;
	SqlSession session = getSqlSession();
	flag = session.insert("insertMy_Study_Check",study_check) > 0 ?true:false;
	return flag;
}


public boolean updateStudyCheckName(StudyCheck study_check){
    boolean flag = false;
	SqlSession session = getSqlSession();
	
	flag = session.update("updateStudy_Check_Name",study_check) > 0 ?true:false;
	
	return flag;
}


public boolean removeMyStudyCheck(String member_id, int study_no) {
	boolean flag = false;
	SqlSession session = getSqlSession();
		HashMap<String, Object>map = new HashMap<String, Object>();
		map.put("member_id",member_id);
		map.put("study_no",study_no);
	flag = session.delete("removeMyStudyCheck",map) > 0 ?true:false;
	return flag;
}




	
}
