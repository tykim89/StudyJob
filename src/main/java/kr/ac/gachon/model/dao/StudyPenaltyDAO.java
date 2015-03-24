package kr.ac.gachon.model.dao;

import kr.ac.gachon.model.vo.StudyPenalty;

public interface StudyPenaltyDAO {
	public StudyPenalty findMoneyByNum(int study_no);
	public boolean updateStudy_Penalty(StudyPenalty study_penalty);
	public boolean insertStudyPenalty(StudyPenalty study_penalty);
}
