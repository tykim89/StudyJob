package kr.ac.gachon.model.dao;

import kr.ac.gachon.model.vo.StudyCheck;

public interface StudyCheckDAO {
	public boolean updateStudyAttendanceCheck(StudyCheck study_check);
	public boolean updatePenalty(StudyCheck study_check);
	public int findAttendanceCount(String attendance_information, String member_id, int study_no);
	public int findSumPenalty(String member_id, int study_no);
	public boolean createMyStudyCheck(StudyCheck study_check);
	public boolean updateStudyCheckName(StudyCheck study_check);
	public boolean removeMyStudyCheck(String member_id, int study_no);
}
