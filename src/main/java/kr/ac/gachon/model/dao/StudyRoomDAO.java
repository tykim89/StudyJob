package kr.ac.gachon.model.dao;

import java.util.List;

import kr.ac.gachon.model.vo.StudyRoom;


public interface StudyRoomDAO {
	
	public boolean create(StudyRoom studyroom);
	public boolean update(StudyRoom studyroom);
	public boolean remove(int studyRoomNo);
	public List<StudyRoom> StudyRoomList();
	public List<StudyRoom> CategoryStudyRoomList(String studyRoomCategory);
	public List<StudyRoom> findStudyRoom(String search);
}
