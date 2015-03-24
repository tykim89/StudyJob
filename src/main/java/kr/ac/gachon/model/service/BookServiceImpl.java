package kr.ac.gachon.model.service;

import java.util.List;

import kr.ac.gachon.model.dao.BookCommentDAO;
import kr.ac.gachon.model.dao.BookDAO;
import kr.ac.gachon.model.vo.Book;
import kr.ac.gachon.model.vo.BookComment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("bookService")
public class BookServiceImpl implements BookService{

	private BookDAO bookDao;
	private BookCommentDAO bookCommentDao;
	
	
	@Autowired
	public void setBookDao(BookDAO bookDao) {
		this.bookDao = bookDao;
	}

	@Autowired
	public void setBookCommentDao(BookCommentDAO bookCommentDao) {
		this.bookCommentDao = bookCommentDao;
	}
	
	// ���� �Խ��� �� ��� ��ȸ
	public List<Book> getBookList(){
		return bookDao.BookList();
	}
	
	// ���� �Խ��� �� ���� ��ȸ (�� ���� + ���)
	public Book getBookContent(int bookNo){
		return bookDao.BookContentCheck(bookNo);
	}
	public List<BookComment> getBookCommentList(int bookNo){
		return bookCommentDao.BookCommentList(bookNo);
	}
	
	// ���� �Խ��� �˻� (����)
	public List<Book> getFindBookByTitle(String search){
		return bookDao.findBookByTitle(search);
	}
	// ���� �Խ��� �˻� (���̵�)
	public List<Book> findBookById(String search){
		return bookDao.findBookById(search);
	}
	
	// ���� �Խ��� �� ����
	public boolean insertBook(Book book){
		return bookDao.create(book);
	}
	
	// ���� �Խ��� �� ����
	public boolean updateBook(Book book){
		return bookDao.update(book);
	}
	
	// ���� �Խ��� �� ����
	public boolean deleteBook(int bookNo){
		return bookDao.remove(bookNo);
	}
	
	
	// ���� �Խ��� ��� ����
	public boolean insertBookComment(BookComment bookComment){
		return bookCommentDao.create(bookComment);
	}
	
	
	public List<Book> getBookPage(int start, int end){
		return bookDao.selectByPaging(start, end);
	}
	public int getBookCount(){
		return bookDao.selectCount();
	}
	public List<Book> getBookTitleSearch(String bookTitle, int start, int end){
		return bookDao.selectTitleSearch(bookTitle, start, end);
	}
	public List<Book> getBookIdSearch(String memberId, int start, int end){
		return bookDao.selectIdSearch(memberId, start, end);
	}
	public int getBookSearchCount(String title){
		return bookDao.selectTitleSearchCount(title);
	}
	public int getBookIdSearchCount(String id){
		return bookDao.selectIdSearchCount(id);
	}
	
}

