package kr.ac.gachon.model.service;

import java.util.List;

import kr.ac.gachon.model.vo.StudyRoom;

public interface StudyRoomService {
	
	public List<StudyRoom> getAllStudyRoomList(); // ���͵�� ��ü ��� ��ȸ
	public List<StudyRoom> getCategoryStudyRoomList(String studyRoomCategory); // ���͵�� �������� ��� ��ȸ
	public boolean insertStudyRoom(StudyRoom studyroom); // ���͵�� ���� �߰�
	public boolean updateStudyRoom(StudyRoom studyroom); // ���͵�� ���� ����
	public boolean deleteStudyRoom(int studyRoomNo); // ���͵�� ���� ����
}
