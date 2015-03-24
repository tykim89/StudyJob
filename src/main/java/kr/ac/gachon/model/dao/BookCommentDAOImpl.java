package kr.ac.gachon.model.dao;

import java.util.List;

import kr.ac.gachon.model.vo.BookComment;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;


@Component("bookCommentDAO")
public class BookCommentDAOImpl extends SqlSessionDaoSupport implements BookCommentDAO{

	public boolean create(BookComment bookComment){
		boolean flag = false;
		
		SqlSession session = getSqlSession();
		flag = session.insert("insertBookComment", bookComment) > 0 ? true : false;
		return flag;
	}

	
	public boolean update(BookComment bookComment){
		boolean flag = false;
		
		SqlSession session = getSqlSession();
		flag = session.update("updateBookComment", bookComment) > 0 ? true : false;
		return flag;
	}
	
	public boolean remove(int commentNo){
		boolean flag = false;
		SqlSession session = getSqlSession();
			flag = session.delete("deleteBookComment", commentNo) > 0 ? true : false;
		return flag;
	}
	
	public List<BookComment> BookCommentList(int bookNo){
		SqlSession session = getSqlSession();
		return session.selectList("selectBookCommentByBookNo", bookNo);
	}
	
}
