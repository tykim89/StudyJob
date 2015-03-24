package kr.ac.gachon.model.service;

import java.util.List;

import kr.ac.gachon.model.vo.Member;
import kr.ac.gachon.model.vo.MemberStudyParticipation;
import kr.ac.gachon.model.vo.Study;
import kr.ac.gachon.model.vo.StudyCheck;
import kr.ac.gachon.model.vo.StudyInfo;
import kr.ac.gachon.model.vo.StudyPenalty;

public interface MyStudyService {
	public List<Study> getMyStudyList(String member_id);
	public Study getStudyTitle(int study_no);
	public List<StudyInfo> getDateByStudy(int study_no);
	public StudyPenalty getMoneyByNum(int study_no);
	public List<MemberStudyParticipation> findMemberStudyParticipation2(int study_no);
	public Member findMeberNamePhon(String member_id);
	public int findAttendanceCount(String attendance_information, String member_id, int study_no);
	public int findSumPenalty(String member_id, int study_no);
	public boolean updateTitle(Study study);
	public boolean updateStudy_Info(StudyInfo study_info);
	public boolean updateStudy_Penalty(StudyPenalty study_penalty);
	public StudyInfo findStudyByDateInfo(String my_study_date, int study_no);
	public boolean deleteStudy_Info(String my_study_date, int study_no);
	public boolean createMyDate(StudyInfo study_info);
	public boolean createMyStudyCheck(StudyCheck study_check);
	public boolean updateStudyCheckName(StudyCheck study_check);
	public boolean updateStudyAttendanceCheck(StudyCheck study_check);
	public boolean updatePenalty(StudyCheck study_check);
	public boolean removeMyStudy(String member_id, int study_no);
	public boolean removeMyStudyCheck(String member_id, int study_no);
	public boolean insertStudyPenalty(StudyPenalty study_penalty);
}
