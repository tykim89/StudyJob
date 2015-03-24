package kr.ac.gachon.model.service;

import java.util.HashMap;
import java.util.List;

import kr.ac.gachon.model.vo.MemberStudyParticipation;
import kr.ac.gachon.model.vo.Study;
import kr.ac.gachon.model.vo.Study_Comment;

public interface StudyService {

	public List<Study> getStudyList();
	public Study getStudyByNo(int studyNo);
	public List<Study_Comment> getStudyComment(int studytNo);

	public boolean insertStudy(Study study);
	public boolean insertStudyComment(Study_Comment study_comment);
	public int selectByMemberCount(int studyNo);
	public boolean insertParticipation(HashMap<String, Object> map);
	public boolean deleteStudy(int studyNo);
	public List<Study> getStudyPage(int start, int end);
	public List<Study> getStudyCategory(String study_category, int start, int end);
	public int getStudyCount();
	public List<Study> getStudyTitleSearch(String studyTitle, int start, int end);
	public List<Study> getStudyIdSearch(String memberId, int start, int end);
	public int getStudySearchCount(String studyTitle);
	public int getStudyIdSearchCount(String memberId);
	public int getStudyCategoryCount(String study_category);
	public boolean editStudy(Study study);
	public List<MemberStudyParticipation> findMemberStudyParticipation(int study_no);
	public List<Study> getStudyByArea(String studyArea, String studyRigion, int start, int end);
	public int getStudyByAreaCount(String studyArea, String studyRigion);
	public int getSelectCurrentStudyNo();
}
