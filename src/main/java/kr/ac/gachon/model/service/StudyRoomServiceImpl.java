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
	
	// ���͵�� ��ü ��� ��ȸ
	public List<StudyRoom> getAllStudyRoomList(){
		return studyRoomDao.StudyRoomList();
	}
		
	// ���͵�� �������� ��� ��ȸ
	public List<StudyRoom> getCategoryStudyRoomList(String studyRoomCategory){
		return studyRoomDao.CategoryStudyRoomList(studyRoomCategory);
	}
		
	// ���͵�� ���� �߰�
	public boolean insertStudyRoom(StudyRoom studyroom){
		return studyRoomDao.create(studyroom);
	}
		
	// ���͵�� ���� ����
	public boolean updateStudyRoom(StudyRoom studyroom){
		return studyRoomDao.update(studyroom);
	}
		
	// ���͵�� ���� ����
	public boolean deleteStudyRoom(int studyRoomNo){
		return studyRoomDao.remove(studyRoomNo);
	}
		
}
