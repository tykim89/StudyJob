package kr.ac.gachon.model.dao;

import java.util.List;

import kr.ac.gachon.model.vo.Study;

public interface StudyDAO {
	public Study findStudytitle(int study_no);
	public boolean updateTitle(Study study);
	
	public boolean create(Study study);
	public boolean update(Study study);
	public boolean remove(int study_no);
	public Study findStudyByNo(int study_no);
	public List<Study> findAllStudy();
	public List<Study> selectByPaging(int start, int end);
	public List<Study> selectByCategory(String study_category, int start, int end);
	public int selectCount();
	public List<Study> selectTitleSearch(String bookTitle, int start, int end);
	public List<Study> selectIdSearch(String member_id, int start, int end);
	public int selectTitleSearchCount(String study_title);
	public int selectIdSearchCount(String member_id);
	public int selectCategoryCount(String study_category);
	public List<Study> selectStudyByArea(String studyArea, String studyRigion, int start, int end);
	public int selectStudyByAreaCount(String studyArea, String studyRigion);
	public int selectCurrentStudyNo();
}
