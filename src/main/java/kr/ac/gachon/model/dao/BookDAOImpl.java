package kr.ac.gachon.model.dao;

import java.util.HashMap;
import java.util.List;

import kr.ac.gachon.model.vo.Book;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;


@Component("bookDAO")
public class BookDAOImpl extends SqlSessionDaoSupport implements BookDAO{

	public boolean create(Book book){
		boolean flag = false;
		SqlSession session = getSqlSession();

		flag = session.insert("insertBook", book) > 0 ? true : false;
		return flag;
	}
	
	public boolean update(Book book){
		boolean flag = false;
		SqlSession session = getSqlSession();

		flag = session.update("updateBook", book) > 0 ? true : false;
		return flag;
	}
	
	public boolean remove(int bookNo){
		boolean flag = false;
		SqlSession session = getSqlSession();
		
		flag = session.delete("deleteBook", bookNo) > 0 ? true : false;
		return flag;
	}
	
	public List<Book> BookList(){
		
		SqlSession session = getSqlSession();
		return session.selectList("selectAllBook");
	}
	
	public Book BookContentCheck(int bookNo){
		SqlSession session = getSqlSession();
		return session.selectOne("selectBookContent", bookNo);
		
	}
	
	public List<Book> findBookByTitle(String search){
		SqlSession session = getSqlSession();
		return session.selectList("searchBookByTitle", search);
	}
	
	public List<Book> findBookById(String search){
		SqlSession session = getSqlSession();
		return session.selectList("searchBookById", search);
	}
	
	public List<Book> selectTitleSearch(String bookTitle, int start, int end){
		SqlSession session = getSqlSession();

		HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("bookTitle", bookTitle);
			map.put("start", start);
			map.put("end", end);
		return session.selectList("searchBookByTitle", map);
	}
	
	public List<Book> selectIdSearch(String memberId, int start, int end){
		SqlSession session = getSqlSession();
		
		HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("memberId", memberId);
			map.put("start", start);
			map.put("end", end);
		return session.selectList("searchBookById", map);
	}
	
	public List<Book> selectByPaging(int start,int end){
		SqlSession session = getSqlSession();

		HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("start", start);
			map.put("end", end);
			return session.selectList("selectBookPage", map);
	}

	public int selectCount(){
		SqlSession session = getSqlSession();
		return session.selectOne("selectCount");
	}
	
	public int selectTitleSearchCount(String title){
		SqlSession session = getSqlSession();
		return session.selectOne("selectTitleSearchCount", title);
	}
	
	public int selectIdSearchCount(String id){
		SqlSession session = getSqlSession();
		return session.selectOne("selectIdSearchCount", id);
	}
}
