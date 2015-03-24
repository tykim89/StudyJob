package kr.ac.gachon.model.dao;

import java.util.List;

import kr.ac.gachon.model.vo.StudyRoom;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;


@Component("studyRoomDAO")
public class StudyRoomDAOImpl extends SqlSessionDaoSupport implements StudyRoomDAO{

	public boolean create(StudyRoom studyroom){
		boolean flag = false;
		SqlSession session = getSqlSession();
		flag = session.insert("insertStudyRoom", studyroom) > 0 ? true : false;
		return flag;
	}
	
	
	public boolean update(StudyRoom studyroom){
		boolean flag = false;
		SqlSession session = getSqlSession();
		flag = session.update("updateStudyRoom", studyroom) > 0 ? true : false;
		return flag;
	}
	
	
	public boolean remove(int studyRoomNo){
		boolean flag = false;
		SqlSession session = getSqlSession();
		flag = session.delete("deleteStudyRoom", studyRoomNo) > 0 ? true : false;
		return flag;
	}
	
	public List<StudyRoom> StudyRoomList(){
		SqlSession session = getSqlSession();
		return session.selectList("selectAllStudyRoom");
	}
	
	public List<StudyRoom> CategoryStudyRoomList(String studyRoomCategory){
		SqlSession session = getSqlSession();
		return session.selectList("selectStudyRoomByCategory", studyRoomCategory);
	}
	
	public List<StudyRoom> findStudyRoom(String search){
		SqlSession session = getSqlSession();
		return session.selectList("searchStudyRoom", search);
	}
	
}