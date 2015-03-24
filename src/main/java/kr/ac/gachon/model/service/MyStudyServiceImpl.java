package kr.ac.gachon.model.service;

import java.util.List;

import kr.ac.gachon.model.dao.MemberDAO;
import kr.ac.gachon.model.dao.MemberStudyParticipationDAO;
import kr.ac.gachon.model.dao.StudyCheckDAO;
import kr.ac.gachon.model.dao.StudyDAO;
import kr.ac.gachon.model.dao.StudyInfoDAO;
import kr.ac.gachon.model.dao.StudyPenaltyDAO;
import kr.ac.gachon.model.vo.Member;
import kr.ac.gachon.model.vo.MemberStudyParticipation;
import kr.ac.gachon.model.vo.Study;
import kr.ac.gachon.model.vo.StudyCheck;
import kr.ac.gachon.model.vo.StudyInfo;
import kr.ac.gachon.model.vo.StudyPenalty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("myStudyService")
public class MyStudyServiceImpl implements MyStudyService {

	private MemberDAO memberdao;
	private StudyDAO studyDao;
	private MemberStudyParticipationDAO  mspDao;
	private StudyInfoDAO studyInfoDao;
	private StudyPenaltyDAO studyPenaltyDao;
	private StudyCheckDAO studyCheckDao;

	
	@Autowired
	public void setMemberdao(MemberDAO memberdao) {
		this.memberdao = memberdao;
	}
	
	
	@Autowired
	public void setStudyPenaltyDao(StudyPenaltyDAO studyPenaltyDao) {
		this.studyPenaltyDao = studyPenaltyDao;
	}

	@Autowired
	public void setStudyDao(StudyDAO studyDao) {
		this.studyDao = studyDao;
	}

	@Autowired
	public void setMspDao(MemberStudyParticipationDAO mspDao) {
		this.mspDao = mspDao;
	}
	
	@Autowired
	public void setStudyInfoDao(StudyInfoDAO studyInfoDao) {
		this.studyInfoDao = studyInfoDao;
	}
	
	@Autowired
	public void setStudyCheckDao(StudyCheckDAO studyCheckDao) {
		this.studyCheckDao = studyCheckDao;
	}
	
	
	
	/////////////////////////////////////////////////////////////////
	
	
	public List<Study> getMyStudyList(String member_id){
		return mspDao.findParticipationListById(member_id);
	}
	
	
	public Study getStudyTitle(int study_no){
		return studyDao.findStudytitle(study_no);
	}

	
	public List<StudyInfo> getDateByStudy(int study_no){
		return studyInfoDao.findDateByStudy(study_no);
	}
	
	public StudyPenalty getMoneyByNum(int study_no){
		return studyPenaltyDao.findMoneyByNum(study_no);
	}
	
	public List<MemberStudyParticipation> findMemberStudyParticipation2(int study_no){
		return mspDao.findMemberStudyParticipation2(study_no);
	}
	
	public Member findMeberNamePhon(String member_id){
		return memberdao.findMeberNamePhon(member_id);
	}
	public int findAttendanceCount(String attendance_information, String member_id, int study_no){
		return studyCheckDao.findAttendanceCount(attendance_information, member_id, study_no);
	}

	public int findSumPenalty(String member_id, int study_no){
		return studyCheckDao.findSumPenalty(member_id, study_no);
	}


	public boolean updateTitle(Study study) {
		// TODO Auto-generated method stub
		return studyDao.updateTitle(study);
	}

	public boolean updateStudy_Info(StudyInfo study_info) {
		// TODO Auto-generated method stub
		return studyInfoDao.updateStudy_Info(study_info);
	}


	public boolean updateStudy_Penalty(StudyPenalty study_penalty) {
		return studyPenaltyDao.updateStudy_Penalty(study_penalty);
	}


	
	public StudyInfo findStudyByDateInfo(String my_study_date, int study_no) {
		// TODO Auto-generated method stub
		return studyInfoDao.findStudyByDateInfo(my_study_date, study_no);
	}


	public boolean deleteStudy_Info(String my_study_date, int study_no) {
		return studyInfoDao.deleteStudy_Info(my_study_date, study_no);
	}


	public boolean createMyDate(StudyInfo study_info) {
		return studyInfoDao.createMyDate(study_info);
	}


	public boolean createMyStudyCheck(StudyCheck study_check) {
		return studyCheckDao.createMyStudyCheck(study_check);
	}


	public boolean updateStudyCheckName(StudyCheck study_check) {
		return studyCheckDao.updateStudyCheckName(study_check);
	}


	public boolean updateStudyAttendanceCheck(StudyCheck study_check) {
		return studyCheckDao.updateStudyAttendanceCheck(study_check);
	}


	public boolean updatePenalty(StudyCheck study_check) {
		return studyCheckDao.updatePenalty(study_check);
	}


	public boolean removeMyStudy(String member_id, int study_no) {
		return mspDao.removeMyStudy(member_id, study_no);
	}


	public boolean removeMyStudyCheck(String member_id, int study_no) {
		return studyCheckDao.removeMyStudyCheck(member_id, study_no);
	}

	public boolean insertStudyPenalty(StudyPenalty study_penalty){
		return studyPenaltyDao.insertStudyPenalty(study_penalty);
	}
	
}
