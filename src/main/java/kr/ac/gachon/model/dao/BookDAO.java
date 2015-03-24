package kr.ac.gachon.model.dao;

import java.util.List;
import kr.ac.gachon.model.vo.Book;


public interface BookDAO {
	
	public boolean create(Book book);
	public boolean update(Book book);
	public boolean remove(int bookNo);
	public List<Book> BookList();
	public Book BookContentCheck(int bookNo);
	public List<Book> findBookByTitle(String search);
	public List<Book> findBookById(String search);
	public List<Book> selectTitleSearch(String bookTitle, int start, int end);
	public List<Book> selectIdSearch(String memberId, int start, int end);
	public List<Book> selectByPaging(int start,int end);
	public int selectCount();
	public int selectTitleSearchCount(String title);
	public int selectIdSearchCount(String id);
}
