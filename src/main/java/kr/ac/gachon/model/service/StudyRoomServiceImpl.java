package kr.ac.gachon.model.service;

import java.util.List;

import kr.ac.gachon.model.dao.StudyRoomDAO;
import kr.ac.gachon.model.vo.StudyRoom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("studyroom")
public class StudyRoomServiceImpl implements StudyRoomService {

	private StudyRoomDAO studyRoomDao;
	
	@Autowired
	public void setStudyRoomDao(StudyRoomDAO studyRoomDao) {
		this.studyRoomDao = studyRoomDao;
	}
	
	// 스터디룸 전체 목록 조회
	public List<StudyRoom> getAllStudyRoomList(){
		return studyRoomDao.StudyRoomList();
	}
		
	// 스터디룸 지역별로 목록 조회
	public List<StudyRoom> getCategoryStudyRoomList(String studyRoomCategory){
		return studyRoomDao.CategoryStudyRoomList(studyRoomCategory);
	}
		
	// 스터디룸 정보 추가
	public boolean insertStudyRoom(StudyRoom studyroom){
		return studyRoomDao.create(studyroom);
	}
		
	// 스터디룸 정보 수정
	public boolean updateStudyRoom(StudyRoom studyroom){
		return studyRoomDao.update(studyroom);
	}
		
	// 스터디룸 정보 삭제
	public boolean deleteStudyRoom(int studyRoomNo){
		return studyRoomDao.remove(studyRoomNo);
	}
		
}
