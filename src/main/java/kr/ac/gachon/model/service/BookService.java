package kr.ac.gachon.model.service;

import java.util.List;

import kr.ac.gachon.model.vo.Book;
import kr.ac.gachon.model.vo.BookComment;
import kr.ac.gachon.model.vo.StudyRoom;

public interface BookService {

		public List<Book> getBookList(); // 도서 게시판 글 목록 조회
		public Book getBookContent(int bookNo); // 도서 게시판 글 내용 조회 (글 내용 + 댓글)
		public List<BookComment> getBookCommentList(int bookNo);
		public List<Book> getFindBookByTitle(String search); // 도서 게시판 검색 (제목)
		public List<Book> findBookById(String search); // 도서 게시판 검색 (아이디)
		public boolean insertBook(Book book); // 도서 게시판 글 쓰기
		public boolean updateBook(Book book); // 도서 게시판 글 수정
		public boolean deleteBook(int bookNo); // 도서 게시판 글 삭제
		public boolean insertBookComment(BookComment bookComment); // 도서 게시판 댓글 쓰기
		
		public List<Book> getBookPage(int start, int end);
		public int getBookCount();
		public List<Book> getBookTitleSearch(String bookTitle, int start, int end);
		public List<Book> getBookIdSearch(String memberId, int start, int end);
		public int getBookSearchCount(String title);
		public int getBookIdSearchCount(String id);
		
		
}
