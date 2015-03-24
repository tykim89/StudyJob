package kr.ac.gachon.model.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import kr.ac.gachon.model.service.FreeBoardService;
import kr.ac.gachon.model.service.NoticeService;
import kr.ac.gachon.model.vo.FreeBoard;
import kr.ac.gachon.model.vo.FreeBoardComment;
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
public class FreeBoardListController {
	
	private FreeBoardService FreeBoardService;
	private NoticeService NoticeService;
	
	@Autowired
	public void setNoticeService(NoticeService noticeService) {
		NoticeService = noticeService;
	}

	@Autowired
	public void setFreeBoardService(FreeBoardService freeBoardService) {
		FreeBoardService = freeBoardService;
	}
	
	@RequestMapping(value = "/controller/freeboard.do", method = RequestMethod.GET)
	public ModelAndView getFreeBoardList(int start, int end, int nowPage, Model model){
		
		ModelAndView mav = new ModelAndView();
		
		int totalCount = FreeBoardService.getFreeboardCount();
		List<FreeBoard> freeboardList = FreeBoardService.getFreeboardPage(start, end);
		List<Notice> noticeList = NoticeService.getNoticeCategory(1, 3, "자유게시판");
		
		mav.setViewName("freeboard_list");
		mav.addObject("totalCount", totalCount);
		mav.addObject("freeboardList",freeboardList);
		mav.addObject("noticeList", noticeList);
		
		return mav;
	}
	
	@RequestMapping(value = "/controller/freeboardView.do", method = RequestMethod.GET)
	public ModelAndView getFreeBoardByNo(int no){
		
		ModelAndView mav = new ModelAndView();
		
		FreeBoard freeboard = FreeBoardService.getFreeboardByNo(no);
		List<FreeBoardComment> fboardCommList = FreeBoardService.getFreeboardComment(no);
		
		mav.setViewName("freeboard_view");
		mav.addObject("freeboard", freeboard);
		mav.addObject("fboardCommList", fboardCommList);
		
		return mav;
	}
	
	@RequestMapping(value = "/controller/newfreeboard.do", method = RequestMethod.POST)
	public String insertFreeBoard(HttpSession session,
			@ModelAttribute("freeboard") FreeBoard freeboard, Model model){
		
		String memberId = (String)session.getAttribute("member_id");
		freeboard.setMemberId(memberId);
		model.addAttribute(freeboard);
		
//		FreeBoard fb = new FreeBoard(memberId, title, content);
		FreeBoardService.insertFreeboard(freeboard);
		
		return "redirect:/controller/freeboard.do?start=1&end=10&nowPage=1";
	}
	
	@RequestMapping(value = "/controller/freeboardComm.do", method = RequestMethod.POST)
	public String insertFreeBoardComm(@RequestParam("freeboardNo") int no, HttpSession session,
			@ModelAttribute("freeboardComm")FreeBoardComment freeboardComm, Model model){
		
		String memberId = (String)session.getAttribute("member_id");
		freeboardComm.setMemberId(memberId);
		freeboardComm.setFreeboardNo(no);
		
		model.addAttribute(freeboardComm);
		
		
//		FreeBoardComment fbc = new FreeBoardComment(no, comment, memberId);
		FreeBoardService.insertFreeboardComm(freeboardComm);
		
		return "redirect:/controller/freeboardView.do?no="+no;
	}
	
	@RequestMapping("/controller/freeboardwrite.do")
	public String write(){
		return "freeboard_write";
	}
	
	@RequestMapping(value="/controller/freeboardSearchTitle.do", method = RequestMethod.POST)
	public ModelAndView getFreeBoardSearch(@RequestParam("searchKey")String key,
			@RequestParam("searchVal")String searchVal, int start, int end, int nowPage, Model model){
		
		ModelAndView mav = new ModelAndView();
	
		if(key.equals("title")){
			List<FreeBoard> fbsearch = FreeBoardService.getFreeboardTitleSearch(searchVal, start, end);
			int totalCount = FreeBoardService.getFreeboardSearchCount(searchVal);
			mav.addObject("fbsearch", fbsearch);
			mav.addObject("totalCount", totalCount);
			
		}else if(key.equals("memberId")){
			List<FreeBoard> fbsearch = FreeBoardService.getFreeboardMemberIdSearch(searchVal, start, end);
			int totalCount = FreeBoardService.getFreeboardIdSearchCount(searchVal);
			mav.addObject("fbsearch", fbsearch);
			mav.addObject("totalCount", totalCount);
		}
		mav.setViewName("freeboard_search");
		
		return mav;
	}
	
	@RequestMapping(value = "/controller/freeboardDelete.do", method = RequestMethod.GET)
	public String delectFreeBoard(int freeboardNo){
		
		FreeBoardService.delectFreeboard(freeboardNo);
	
		return "redirect:/controller/freeboard.do?start=1&end=10&nowPage=1";
	
			
	}
	
	@RequestMapping(value = "/controller/editfreeboard.do", method = RequestMethod.POST)
	public String updateFreeBoard(@RequestParam("freeboardNo")int no,
			@ModelAttribute("freeboard") FreeBoard freeBoard, Model model){
		
		freeBoard.setFreeboardNo(no);
		System.out.println(no);
		model.addAttribute(freeBoard);
		
		FreeBoardService.editFreeboard(freeBoard);
		return "redirect:/controller/freeboardView.do?no="+no;
	}
	
	@RequestMapping(value = "/controller/freeboardEdit.do", method = RequestMethod.GET)
	public ModelAndView edit(int no){
		ModelAndView mav = new ModelAndView();
		
		FreeBoard freeboard = FreeBoardService.getFreeboardByNo(no);
		
		mav.setViewName("freeboard_edit");
		mav.addObject("freeboard", freeboard);
		
		return mav;
	}
}
