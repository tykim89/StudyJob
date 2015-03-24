package kr.ac.gachon.model.dao;

import java.util.HashMap;
import java.util.List;

import kr.ac.gachon.model.vo.Study;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;

@Component("studyDAO")
public class StudyDAOImpl extends SqlSessionDaoSupport implements StudyDAO  {

	public Study findStudytitle(int study_no){
		SqlSession session = getSqlSession();
		return session.selectOne("selectStudyTitleById", study_no);
	}

	public boolean updateTitle(Study study){
		boolean flag = false;
		SqlSession session = getSqlSession();
		flag = session.update("updateTitle",study) > 0 ?true:false;
		return flag;
	}

	
	
	public boolean create(Study study) {
		boolean flag = false;
		SqlSession session = getSqlSession();
		System.out.println("dao : "+session+","+study);
		flag = session.insert("insertStudy", study) > 0 ? true : false;
		System.out.println("flag : "+flag);
		return flag;
	}

	public boolean update(Study study) {
		boolean flag = false;
		SqlSession session = getSqlSession();
		flag = session.update("updateStudy", study) > 0 ? true : false;
		return flag;
	}

	public boolean remove(int study_no) {
		boolean flag = false;
		SqlSession session = getSqlSession();
		flag = session.delete("deleteStudy", study_no) > 0 ? true : false;
		return flag;
	}

	public Study findStudyByNo(int study_no) {
		SqlSession session = getSqlSession();
		return session.selectOne("selectStudyByNo", study_no);
	}

	public List<Study> findAllStudy() {
		SqlSession session = getSqlSession();
		return session.selectList("selectAllStudy");

	}

	public List<Study> selectByPaging(int start, int end) {
		SqlSession session = getSqlSession();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("start", start);
		map.put("end", end);
		return session.selectList("selectStudyPage", map);
	}

	public List<Study> selectByCategory(String study_category, int start, int end) {
		SqlSession session = getSqlSession();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("study_category", study_category);
		map.put("start", start);
		map.put("end", end);
		return session.selectList("selectCategory", map);
	}

	public int selectCount() {
		SqlSession session = getSqlSession();
		return session.selectOne("selectStudyCount");
	}

	public List<Study> selectTitleSearch(String study_title, int start, int end) {
		SqlSession session = getSqlSession();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("study_title", study_title);
		map.put("start", start);
		map.put("end", end);
		return session.selectList("searchStudyByTitle", map);
	}

	public List<Study> selectIdSearch(String member_id, int start, int end) {
		SqlSession session = getSqlSession();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("member_id", member_id);
		map.put("start", start);
		map.put("end", end);
		return session.selectList("searchStudyById", map);
	}

	public int selectTitleSearchCount(String study_title) {
		SqlSession session = getSqlSession();
		return session.selectOne("selectStudyTitleSearchCount", study_title);
	}

	public int selectIdSearchCount(String member_id) {
		SqlSession session = getSqlSession();
		return session.selectOne("selectStudyIdSearchCount", member_id);
	}

	public int selectCategoryCount(String study_category) {
		SqlSession session = getSqlSession();
		return session.selectOne("selectCategoryCount", study_category);
	}

	public List<Study> selectStudyByArea(String studyArea, String studyRigion, int start, int end){
		SqlSession session = getSqlSession();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("studyArea", studyArea);
		map.put("studyRigion", studyRigion);
		map.put("start", start);
		map.put("end", end);
		return session.selectList("selectStudyByArea", map);
	}
	
	public int selectStudyByAreaCount(String studyArea, String studyRigion){
		SqlSession session = getSqlSession();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("studyArea", studyArea);
		if(studyRigion != null ){
			map.put("studyRigion", studyRigion);
		}
		return session.selectOne("selectStudyByAreaCount", map);
	}
	
	public int selectCurrentStudyNo(){
		SqlSession session = getSqlSession();
		return session.selectOne("selectCurrentStudyNo");
	}
}
