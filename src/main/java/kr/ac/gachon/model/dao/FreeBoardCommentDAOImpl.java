package kr.ac.gachon.model.dao;

import java.util.List;

import kr.ac.gachon.model.vo.FreeBoardComment;
import kr.ac.gachon.util.MyBatisConfig;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;

@Component("freeBoardCommentDAO")
public class FreeBoardCommentDAOImpl extends SqlSessionDaoSupport implements FreeBoardCommentDAO {

	public boolean insertCommnet(FreeBoardComment freeboardcomm){
		
		boolean flag = false;
		SqlSession session = getSqlSession();
		
		flag = session.insert("insertFreeBoardComm", freeboardcomm) > 0 ? true
					: false;
		return flag;
	}
	
	public boolean update(FreeBoardComment freeboardcomm){
		boolean flag = false;
		SqlSession session = MyBatisConfig.getSqlSession();
		try{
		flag = session.update("updateFreeBoardComm", freeboardcomm) > 0 ? true : false;
		}finally{
			MyBatisConfig.closeSqlSession(flag, session);
		}
		return flag;
	}
	
	public boolean delete(int commentNo){
		boolean flag = false;
		SqlSession session = MyBatisConfig.getSqlSession();
		try{
			flag = session.delete("deleteFreeBoardComm", commentNo) > 0 ? true : false;
		}finally{
			MyBatisConfig.closeSqlSession(flag, session);
		}
		return flag;
	}
	
	public List<FreeBoardComment> selectCommAll(int freeboardNo){
		SqlSession session = getSqlSession();
		
		return session.selectList("selectFreeBoardCommAll", freeboardNo);
		
	}
	
}
