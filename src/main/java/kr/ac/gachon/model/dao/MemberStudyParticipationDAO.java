package kr.ac.gachon.model.dao;

import java.util.HashMap;
import java.util.List;

import kr.ac.gachon.model.vo.MemberStudyParticipation;
import kr.ac.gachon.model.vo.Study;

public interface MemberStudyParticipationDAO {
	public List<Study> findParticipationListById(String member_id);
	public List<MemberStudyParticipation> findMemberStudyParticipation2(int study_no);
	public boolean removeMyStudy(String member_id, int study_no);
	
	public int findByMemberCount(int study_no);
	public boolean create(HashMap<String, Object> map);
}
