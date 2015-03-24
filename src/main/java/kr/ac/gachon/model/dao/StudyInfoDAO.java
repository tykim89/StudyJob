package kr.ac.gachon.model.dao;

import java.util.List;

import kr.ac.gachon.model.vo.StudyInfo;

public interface StudyInfoDAO {
	public StudyInfo findStudyByDateInfo(String my_study_date, int study_no);
	public List<StudyInfo> findDateByStudy(int study_no);
	public boolean createMyDate(StudyInfo study_info);
	public boolean updateStudy_Info(StudyInfo study_info);
	public boolean deleteStudy_Info(String my_study_date, int study_no);
	
}
