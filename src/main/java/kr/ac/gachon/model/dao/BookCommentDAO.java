package kr.ac.gachon.model.dao;

import java.util.List;
import kr.ac.gachon.model.vo.BookComment;


public interface BookCommentDAO {

	
	public boolean create(BookComment bookComment);

	
	public boolean update(BookComment bookComment);
	
	
	public boolean remove(int commentNo);
	
	
	public List<BookComment> BookCommentList(int bookNo);
	
	
}
