package kr.ac.gachon.model.controller;

import java.util.List;

import kr.ac.gachon.model.service.BookService;
import kr.ac.gachon.model.service.NoticeService;
import kr.ac.gachon.model.vo.Book;
import kr.ac.gachon.model.vo.BookComment;
import kr.ac.gachon.model.vo.Notice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {
	
	private BookService bookService;
	private NoticeService noticeService;
	
	@Autowired
	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}

	@Autowired
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	// 도서 게시판 목록 리스트
	@RequestMapping(value="/controller/bookList.do", method=RequestMethod.GET)
	public ModelAndView getBookList(int start, int end, int nowPage, Model model){
		
		ModelAndView mav = new ModelAndView();
		int totalCount = bookService.getBookCount();
		List<Book> bookList = bookService.getBookPage(start, end);
		List<Notice> noticeList = noticeService.getNoticeCategory(1, 3, "교재관련");
		
		mav.setViewName("bookList");
		mav.addObject("totalCount", totalCount);
		mav.addObject("bookList", bookList);
		mav.addObject("noticeList", noticeList);
		
		return mav;
	}
	
	// 도서 게시판 글 내용(+댓글) 조회
	@RequestMapping(value="/controller/bookContent.do", method=RequestMethod.GET)
	public ModelAndView getBookContent(int bookNo, Model model){
		
		ModelAndView mav = new ModelAndView();
		
		Book bookContent = bookService.getBookContent(bookNo);
		List<BookComment> bookCommentList = bookService.getBookCommentList(bookNo);
		
		mav.setViewName("bookContent");
		mav.addObject("bookContent", bookContent);
		mav.addObject("bookCommentList", bookCommentList);
		
		return mav;
	}
	
	// 도서 게시판 글작성 페이지
	@RequestMapping(value="/controller/write_form", method=RequestMethod.POST)
	public String write_form(){
		return "bookInsert";
	}
	
	// 도서 게시판 글 작성
	@RequestMapping(value="/controller/bookInsert.do", method=RequestMethod.POST)
	public String write_book(HttpSession session,
			@ModelAttribute("book") Book book, Model model		
			){

		String memberId = (String)session.getAttribute("member_id");
		book.setmemberId(memberId);
		model.addAttribute(book);
		
		bookService.insertBook(book);
		
		return "redirect:/controller/bookList.do?start=1&end=10&nowPage=1";
	}
	
	// 도서 게시판 글 수정
	@RequestMapping(value="/controller/bookUpdate.do", method=RequestMethod.POST)
	public String update_book(
			@RequestParam("bookNo") int bookNo,
			@ModelAttribute("bookContent") Book bookContent, 
			Model model
			){
		
		bookContent.setbookNo(bookNo);
		model.addAttribute(bookContent);
		
		bookService.updateBook(bookContent);
		
		return "redirect:/controller/bookContent.do?bookNo="+bookNo;
	}

	@RequestMapping(value="/controller/bookEdit.do", method=RequestMethod.GET)
	public ModelAndView edit(int bookNo){
		ModelAndView mav = new ModelAndView();
	
		Book bookContent = bookService.getBookContent(bookNo);
		
		mav.setViewName("bookUpdate");
		mav.addObject("bookContent", bookContent);
		
		return mav;
	}
	
	// 도서 게시판 글 삭제
	@RequestMapping(value="/controller/deleteBook.do", method=RequestMethod.GET)
	public String delete_book(int bookNo){
		
		bookService.deleteBook(bookNo);
		
		return "redirect:/controller/bookList.do?start=1&end=10&nowPage=1";
	}
	
	// 도서 게시판 댓글 쓰기
	@RequestMapping(value="/controller/insertBookComment.do", method=RequestMethod.POST)
	public String write_comment(HttpSession session,
			@RequestParam("bookNo") int bookNo,
			@ModelAttribute("bookComm")BookComment bookComm, Model model){
		
		String memberId = (String)session.getAttribute("member_id");
		bookComm.setbookNo(bookNo);
		bookComm.setmemberId(memberId);
		System.out.println(bookNo+"//"+memberId);
		model.addAttribute(bookComm);
		bookService.insertBookComment(bookComm);
		
		return "redirect:/controller/bookContent.do?bookNo="+bookNo;
	}
	
	// 도서 게시판 검색(제목, 아이디)
	@RequestMapping(value="/controller/bookSearchTitle.do", method = RequestMethod.POST)
	public ModelAndView getBookTitleSearch(
			@RequestParam("searchKey")String key,
			@RequestParam("searchVal")String searchVal, int start, int end, int nowPage, Model model){

		ModelAndView mav = new ModelAndView();
		
		if(key.equals("title")){
			List<Book> bookSearch = bookService.getBookTitleSearch(searchVal, start, end);
			int totalCount = bookService.getBookSearchCount(searchVal);
			mav.addObject("bookSearch", bookSearch);
			mav.addObject("totalCount", totalCount);
			
		}else{
			List<Book> bookSearch = bookService.getBookIdSearch(searchVal, start, end);
			int totalCount = bookService.getBookIdSearchCount(searchVal);
			mav.addObject("bookSearch", bookSearch);
			mav.addObject("totalCount", totalCount);
		}
		mav.setViewName("bookSearch");
		return mav;
	}
	
}
