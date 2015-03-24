package kr.ac.gachon.model.controller;

import java.util.List;

import kr.ac.gachon.model.service.NoticeService;
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
public class NoticeController {

	private NoticeService noticeService;

	@Autowired
	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}
	
	@RequestMapping(value = "/controller/noticeList.do", method = RequestMethod.GET)
	public ModelAndView getNoticeList(int start, int end, int nowPage){
		
		ModelAndView mav = new ModelAndView();
		int totalCount = noticeService.getNoticeCount();
		
		List<Notice> noticeList = noticeService.getNoticePage(start, end);
		
		System.out.println(noticeList);
		mav.setViewName("noticeList");
		mav.addObject("totalCount", totalCount);
		mav.addObject("noticeList", noticeList);
		
		return mav;
		
	}
	
	@RequestMapping(value = "/controller/notice.do", method = RequestMethod.GET)
	public ModelAndView getNoticeByNo(@RequestParam("no")int noticeNo){
		
		ModelAndView mav = new ModelAndView();
		
		Notice notice = noticeService.getNoticeByNo(noticeNo);
		
		mav.setViewName("noticeView");
		mav.addObject("notice", notice);
		return mav;
	}
	
	@RequestMapping(value = "/controller/newNotice.do", method = RequestMethod.POST)
	public String insertNotice(@ModelAttribute("notice")Notice notice, Model model){
		
		model.addAttribute(notice);
//		Notice notice = new Notice(title, content, studySelect);
		
		System.out.println(notice);
		
		noticeService.insertNotice(notice);
		
		return "redirect:/controller/noticeList.do?start=1&end=10&nowPage=1";
	}
	@RequestMapping("/controller/noticeWrite.do")
	public String write(){
		return "noticeWrite";
	}
	
	@RequestMapping(value = "/controller/deleteNotice.do", method = RequestMethod.POST)
	public String deleteNotice(@RequestParam("no") int noticeNo){
		
		noticeService.deleteNotice(noticeNo);
		
		return "redirect:/controller/noticeList.do?start=1&end=10&nowPage=1";
	}
	
	@RequestMapping(value = "/controller/noticeEdit.do", method = RequestMethod.GET)
	public ModelAndView noticeEdit(int no){
		ModelAndView mav = new ModelAndView();
		
		Notice notice = noticeService.getNoticeByNo(no);
		
		mav.setViewName("noticeEdit");
		mav.addObject("notice", notice);
		
		return mav;
	}
	@RequestMapping(value = "/controller/updateNotice.do", method = RequestMethod.POST)
	public String updateNotice(int noticeNo, 
			@ModelAttribute("notice") Notice notice, Model model){
		
		notice.setNoticeNo(noticeNo);
		model.addAttribute(notice);

		noticeService.editNotice(notice);
		
		return "redirect:/controller/notice.do?no="+noticeNo;
	}
	
	@RequestMapping(value="/controller/noticeSearch.do", method = RequestMethod.POST)
	public ModelAndView getNoticeSearch(@RequestParam("searchKey")String key,
			@RequestParam("searchVal")String searchVal, int start, int end, int nowPage, Model model){
		
		ModelAndView mav = new ModelAndView();
		if(key.equals("title")){
			List<Notice> nsearch = noticeService.getNoticeTitleSearch(searchVal, start, end);
			int totalCount = noticeService.getNoticeTitleSearchCount(searchVal);
			mav.addObject("nsearch", nsearch);
			mav.addObject("totalCount", totalCount);
			
		}else if(key.equals("content")){
			List<Notice> nsearch = noticeService.getNoticeContentSearch(searchVal, start, end);
			int totalCount = noticeService.getNoticeContentSearchCount(searchVal);
			mav.addObject("nsearch", nsearch);
			mav.addObject("totalCount", totalCount);
		}
		mav.setViewName("noticeSearch");
		
		return mav;
	}
}
