package kr.ac.gachon.model.dao;

import java.util.HashMap;
import java.util.List;

import kr.ac.gachon.model.vo.StudyInfo;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;


@Component("studyInfoDAO")
public class StudyInfoDAOImpl extends SqlSessionDaoSupport implements StudyInfoDAO  {

	
	public StudyInfo findStudyByDateInfo(String my_study_date, int study_no){
		
		SqlSession session = getSqlSession();
		HashMap<String, Object>map = new HashMap<String, Object>();
		map.put("my_study_date",my_study_date);
		map.put("study_no",study_no);
		return session.selectOne("selectStudyInfoByDate",map);
	}
	
	
	
	public List<StudyInfo> findDateByStudy(int study_no){
		
		SqlSession session = getSqlSession();
		return session.selectList("selectDateByStudy", study_no);
		
	}
	
	
	public boolean createMyDate(StudyInfo study_info){
	    boolean flag = false;
		SqlSession session = getSqlSession();
		flag = session.insert("insertMy_Study_Date",study_info) > 0 ?true:false;
		return flag;
	}
	
	
	public boolean updateStudy_Info(StudyInfo study_info){
	    boolean flag = false;
		SqlSession session = getSqlSession();
		flag = session.update("updateStudy_Info",study_info) > 0 ?true:false;
		return flag;
	}

	
	public boolean deleteStudy_Info(String my_study_date, int study_no){
	    boolean flag = false;
		SqlSession session = getSqlSession();
			HashMap<String, Object>map = new HashMap<String, Object>();
			map.put("my_study_date",my_study_date);
			map.put("study_no",study_no);
		flag = session.delete("deleteStudy_Info",map) > 0 ?true:false;
		return flag;
	}
	
	
	
	
	
}
