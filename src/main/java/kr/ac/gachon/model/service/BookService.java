package kr.ac.gachon.model.service;

import java.util.List;

import kr.ac.gachon.model.vo.Book;
import kr.ac.gachon.model.vo.BookComment;
import kr.ac.gachon.model.vo.StudyRoom;

public interface BookService {

		public List<Book> getBookList(); // ���� �Խ��� �� ��� ��ȸ
		public Book getBookContent(int bookNo); // ���� �Խ��� �� ���� ��ȸ (�� ���� + ���)
		public List<BookComment> getBookCommentList(int bookNo);
		public List<Book> getFindBookByTitle(String search); // ���� �Խ��� �˻� (����)
		public List<Book> findBookById(String search); // ���� �Խ��� �˻� (���̵�)
		public boolean insertBook(Book book); // ���� �Խ��� �� ����
		public boolean updateBook(Book book); // ���� �Խ��� �� ����
		public boolean deleteBook(int bookNo); // ���� �Խ��� �� ����
		public boolean insertBookComment(BookComment bookComment); // ���� �Խ��� ��� ����
		
		public List<Book> getBookPage(int start, int end);
		public int getBookCount();
		public List<Book> getBookTitleSearch(String bookTitle, int start, int end);
		public List<Book> getBookIdSearch(String memberId, int start, int end);
		public int getBookSearchCount(String title);
		public int getBookIdSearchCount(String id);
		
		
}
