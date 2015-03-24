package kr.ac.gachon.model.dao;

import java.util.List;

import kr.ac.gachon.model.vo.Study_Comment;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;


@Component("study_CommentDAO")
public class Study_CommentDAOImpl extends SqlSessionDaoSupport implements Study_CommentDAO {

	
	public boolean create(Study_Comment study_comment) {
		boolean flag = false;
		SqlSession session = getSqlSession();
		flag = session.insert("insertStudyComment", study_comment) > 0 ? true : false;
		return flag;
	}

	public boolean update(Study_Comment study_comment) {
		boolean flag = false;
		SqlSession session = getSqlSession();
		flag = session.update("updateStudyComment", study_comment) > 0 ? true : false;
		return flag;
	}

	public boolean remove(int commentNo) {
		boolean flag = false;
		SqlSession session = getSqlSession();
		flag = session.delete("deleteStudyComment", commentNo) > 0 ? true : false;
		return flag;
	}
	
	public List<Study_Comment> findAllComment() {
		SqlSession session = getSqlSession();
		return session.selectList("selectAllComment");
	}
	
	public  List<Study_Comment>  findComment(int studyNo) {
		SqlSession session = getSqlSession();
		return session.selectList("selectComment", studyNo);
	}

}
