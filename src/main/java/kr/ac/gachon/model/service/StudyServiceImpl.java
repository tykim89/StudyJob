package kr.ac.gachon.model.service;

import java.util.HashMap;
import java.util.List;

import kr.ac.gachon.model.dao.MemberStudyParticipationDAO;
import kr.ac.gachon.model.dao.StudyDAO;
import kr.ac.gachon.model.dao.Study_CommentDAO;
import kr.ac.gachon.model.vo.MemberStudyParticipation;
import kr.ac.gachon.model.vo.Study;
import kr.ac.gachon.model.vo.Study_Comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("studyService")
public class StudyServiceImpl implements StudyService {

	private StudyDAO dao;
	private Study_CommentDAO scDao;
	private MemberStudyParticipationDAO pdao;

	@Autowired
	public void setDao(StudyDAO dao) {
		this.dao = dao;
	}

	@Autowired
	public void setScDao(Study_CommentDAO scDao) {
		this.scDao = scDao;
	}

	@Autowired
	public void setPdao(MemberStudyParticipationDAO pdao) {
		this.pdao = pdao;
	}

	public List<Study> getStudyList() {
		return dao.findAllStudy();
	}

	public Study getStudyByNo(int study_no) {
		return dao.findStudyByNo(study_no);
	}

	public List<Study_Comment> getStudyComment(int studyt_no) {
		return scDao.findComment(studyt_no);
	}

	public boolean insertStudy(Study study) {
		return dao.create(study);
	}

	public boolean insertStudyComment(Study_Comment study_comment) {
		return scDao.create(study_comment);
	}

	public int selectByMemberCount(int study_no) {
		return pdao.findByMemberCount(study_no);
	}

	public boolean insertParticipation(HashMap<String, Object> map) {
		return pdao.create(map);
	}

	public boolean deleteStudy(int study_no) {
		return dao.remove(study_no);
	}

	public List<Study> getStudyPage(int start, int end) {
		return dao.selectByPaging(start, end);
	}

	public List<Study> getStudyCategory(String study_category, int start,
			int end) {
		return dao.selectByCategory(study_category, start, end);
	}

	public int getStudyCount() {
		return dao.selectCount();
	}

	public List<Study> getStudyTitleSearch(String study_title, int start,
			int end) {
		return dao.selectTitleSearch(study_title, start, end);
	}

	public List<Study> getStudyIdSearch(String member_id, int start, int end) {
		return dao.selectIdSearch(member_id, start, end);
	}

	public int getStudySearchCount(String study_title) {
		return dao.selectTitleSearchCount(study_title);
	}

	public int getStudyIdSearchCount(String member_id) {
		return dao.selectIdSearchCount(member_id);
	}

	public int getStudyCategoryCount(String study_category) {
		return dao.selectCategoryCount(study_category);
	}

	public boolean editStudy(Study study) {
		return dao.update(study);
	}

	public List<MemberStudyParticipation> findMemberStudyParticipation(
			int study_no) {
		return pdao.findMemberStudyParticipation2(study_no);
	}

	public List<Study> getStudyByArea(String studyArea, String studyRigion, int start, int end){
		return dao.selectStudyByArea(studyArea, studyRigion, start, end);
	}
	
	public int getStudyByAreaCount(String studyArea, String studyRigion){
		return dao.selectStudyByAreaCount(studyArea, studyRigion);
	}
	
	public int getSelectCurrentStudyNo(){
		return dao.selectCurrentStudyNo();
	}
}
