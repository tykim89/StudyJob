package kr.ac.gachon.model.service;

import java.util.List;

import kr.ac.gachon.model.vo.StudyRoom;

public interface StudyRoomService {
	
	public List<StudyRoom> getAllStudyRoomList(); // 스터디룸 전체 목록 조회
	public List<StudyRoom> getCategoryStudyRoomList(String studyRoomCategory); // 스터디룸 지역별로 목록 조회
	public boolean insertStudyRoom(StudyRoom studyroom); // 스터디룸 정보 추가
	public boolean updateStudyRoom(StudyRoom studyroom); // 스터디룸 정보 수정
	public boolean deleteStudyRoom(int studyRoomNo); // 스터디룸 정보 삭제
}
