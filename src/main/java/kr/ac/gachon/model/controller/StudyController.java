package kr.ac.gachon.model.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import kr.ac.gachon.model.service.MyStudyService;
import kr.ac.gachon.model.service.NoticeService;
import kr.ac.gachon.model.service.StudyService;
import kr.ac.gachon.model.vo.MemberStudyParticipation;
import kr.ac.gachon.model.vo.Notice;
import kr.ac.gachon.model.vo.Study;
import kr.ac.gachon.model.vo.StudyCheck;
import kr.ac.gachon.model.vo.StudyInfo;
import kr.ac.gachon.model.vo.StudyPenalty;
import kr.ac.gachon.model.vo.Study_Comment;
import kr.ac.gachon.util.StringUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudyController {

	private StudyService StudyService;
	private MyStudyService MyStudyService;
	private NoticeService NoticeService;
	
	
	@Autowired
	public void setNoticeService(NoticeService noticeService) {
		NoticeService = noticeService;
	}
	
	@Autowired
	public void setStudyService(StudyService studyService) {
		StudyService = studyService;
	}
	
	@Autowired
	public void setMyStudyService(MyStudyService myStudyService) {
		MyStudyService = myStudyService;
	}
	
	//글목록
	@RequestMapping(value="/controller/studyList.do",  method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView getStudyList(int start, int end, int nowPage, Model model){
		
		ModelAndView mav = new ModelAndView();
		
		
		int totalCount = StudyService.getStudyCount();
		List<Study> studyList = StudyService.getStudyPage(start, end);
		List<Notice> noticeList = NoticeService.getNoticeCategory(1, 3, "스터디");
		
		mav.setViewName("Study_List");
		mav.addObject("totalCount", totalCount);
		mav.addObject("studyList", studyList);
		mav.addObject("noticeList", noticeList);
		
		return mav;
		
	}

	//글내용
	@RequestMapping(value = "/controller/study.do", method = RequestMethod.GET)
	public ModelAndView getStudyByNo(@RequestParam("no") int study_no,
			Model model) {

		ModelAndView mav = new ModelAndView();

		List<MemberStudyParticipation> spt = StudyService.findMemberStudyParticipation(study_no);
		Study study = StudyService.getStudyByNo(study_no);
		List<Study_Comment> studyCommList = StudyService.getStudyComment(study_no);
		int member_study_participation = StudyService.selectByMemberCount(study_no);
		
		
		mav.setViewName("StudyContent");
		mav.addObject("smemberId",spt);
		mav.addObject("study", study);
		mav.addObject("studyCommList", studyCommList);
		mav.addObject("num", member_study_participation);
	

		return mav;

	}
	
	//글삭제
	@RequestMapping(value = "/controller/deleteStudy.do", method= RequestMethod.GET)
	public String deleteStudy(@RequestParam("no") int study_no){
		
		
		StudyService.deleteStudy(study_no);
		
		return "redirect:/controller/studyList.do?start=1&end=10&nowPage=1";
	}
	
	@RequestMapping(value = "/controller/writeForm", method = RequestMethod.POST)
	public String newStudy(){

		return "newStudy";
		
	}
	
	//글작성
	@RequestMapping(value = "/controller/newStudy.do" ,method = RequestMethod.POST)
	public String  InsertStudy(HttpSession session,@ModelAttribute("studyInfo") StudyInfo studyInfo, @ModelAttribute("studyCheck") StudyCheck studyCheck,
			@ModelAttribute("studyPenalty") StudyPenalty studyPenalty,@ModelAttribute("study")Study study, Model model){
		
		String member_id = (String)session.getAttribute("member_id");
		study.setMember_id(member_id);
		
		model.addAttribute(study);
		
		StudyService.insertStudy(study);
		
		int currentStudyNo = StudyService.getSelectCurrentStudyNo();
		model.addAttribute("currentStudyNo", currentStudyNo);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("study_no", currentStudyNo);
		map.put("memberId", member_id);
		
		model.addAttribute(map);
		
		StudyService.insertParticipation(map);
		
		
		//일정없으면 출석체크 막고 페널티 생성해주기
		studyPenalty.setStudy_no(currentStudyNo);
		studyPenalty.setLateness_money(0);
		studyPenalty.setAbsant_money(0);
		
		
		model.addAttribute(studyPenalty);
		MyStudyService.insertStudyPenalty(studyPenalty);
		
		
		
		return "redirect:/controller/studyList.do?start=1&end=10&nowPage=1";
	}	
	
	//댓글달기
	@RequestMapping(value = "/controller/InsertStudyComm", method = RequestMethod.POST )
	public String write_comm(@RequestParam("studyNo") int studyNo, HttpSession session,
							 @ModelAttribute("studyComm")Study_Comment studyComment, Model model){
		
		String memberId = (String)session.getAttribute("member_id");
		System.out.println(memberId);
		studyComment.setStudyNo(studyNo);
		System.out.println(studyNo);
		studyComment.setMemberId(memberId);
		model.addAttribute(studyComment);
		System.out.println(studyComment);
		StudyService.insertStudyComment(studyComment);
		
		return "redirect:/controller/study.do?no="+studyNo;
	}
	

	//스터디신청
	@RequestMapping(value ="/controller/participateStudy.do", method = RequestMethod.POST)
	public String Participate_Study(@ModelAttribute("studyInfo") StudyInfo studyInfo,@ModelAttribute("studyCheck") StudyCheck studyCheck,
			@RequestParam("no") int study_no, HttpSession session,
			Model model){

		String memberId = (String)session.getAttribute("member_id");
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("study_no", study_no);
		map.put("memberId", memberId);
		
		model.addAttribute(map);
		
		StudyService.insertParticipation(map);
		
		studyInfo.setStudy_no(study_no);
		studyInfo.setMy_study_date("0");
		studyInfo.setMy_study_content("0");
		studyInfo.setMy_study_time("0");
		studyInfo.setMy_study_place("0");
		
		/*boolean flag = true;
		
		if(flag == true){
		studyInfo.setStudy_no(study_no);
		studyInfo.setMy_study_date("0");
		studyInfo.setMy_study_content("0");
		studyInfo.setMy_study_time("0");
		studyInfo.setMy_study_place("0");
		flag = false;
		}else{
			int temp = 
		studyInfo.setStudy_no(study_no);
		studyInfo.setMy_study_date( "studyInfo.setMy_study_date"+1);
		studyInfo.setMy_study_content("0");
		studyInfo.setMy_study_time("0");
		studyInfo.setMy_study_place("0");
		flag = true;
		}*/
		
		
		model.addAttribute(studyInfo);
		MyStudyService.createMyDate(studyInfo);
		
		studyCheck.setMember_id(memberId);
		studyCheck.setMy_study_date("0");
		studyCheck.setStudy_no(study_no);
		studyCheck.setPenalty(0);
		studyCheck.setAttendance_information("0");
		studyCheck.setMember_name("0");
		
		model.addAttribute(studyCheck);
		MyStudyService.createMyStudyCheck(studyCheck);
		
		return "redirect:/controller/study.do?no="+study_no;
	}
	
	// 카테고리
	@RequestMapping(value="/controller/studyCategory.do", method = RequestMethod.GET)
	public ModelAndView getStudyCategory(
			@RequestParam(value="study_category")String study_category, 
			int start, int end, int nowPage, Model model){
		
		ModelAndView mav = new ModelAndView();
		System.out.println(start);
		study_category = StringUtil.toKor(study_category);
		System.out.println(study_category);
		
		List<Study> studyCategory =StudyService.getStudyCategory(study_category, start, end);
		int totalCount = StudyService.getStudyCategoryCount(study_category);

		mav.setViewName("studyCategory");
		mav.addObject("totalCount", totalCount);
		mav.addObject("studyCategory", studyCategory);
		mav.addObject("study_category", study_category);
		return mav;
		
		
	}
	
	//스터디 검색
	@RequestMapping(value="/controller/studyTitleSearch.do", method = RequestMethod.POST)
	public ModelAndView getStudyTitleSearch(
			@RequestParam("searchKey")String key,
			@RequestParam("searchVal")String searchVal, int start, int end, int nowPage, Model model){
		System.out.println(key);
		System.out.println(searchVal);
		ModelAndView mav = new ModelAndView();
		
		if(key.equals("title")){
			List<Study> studySearch = StudyService.getStudyTitleSearch(searchVal, start, end);
			int totalCount = StudyService.getStudySearchCount(searchVal);
			
			mav.addObject("studySearch", studySearch);
			mav.addObject("totalCount", totalCount);
			mav.setViewName("studyTitleSearch");
		}else if(key.equals("id")){
			List<Study> studySearch = StudyService.getStudyIdSearch(searchVal, start, end);
			int totalCount = StudyService.getStudyIdSearchCount(searchVal);
			
			mav.addObject("studySearch", studySearch);
			mav.addObject("totalCount", totalCount);
			mav.setViewName("studyTitleSearch");
		}
		
		return mav;
	}
	
	//글 수정
	@RequestMapping(value = "/controller/editStudy.do", method = RequestMethod.POST)
	public String updateStudy(@RequestParam("study_no")int study_no,
			@ModelAttribute("study") Study study, Model model){
		
		study.setStudy_no(study_no);
		System.out.println(study_no);
		System.out.println(study);
		model.addAttribute(study);
		
		StudyService.editStudy(study);
		return "redirect:/controller/study.do?no="+study_no;
	}
	
	@RequestMapping(value = "/controller/editStudy2.do", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam("no") int study_no, Model model){
		ModelAndView mav = new ModelAndView();
		
		Study study= StudyService.getStudyByNo(study_no);
		
		mav.setViewName("study_edit");
		mav.addObject("study", study);
		
		return mav;
	}
	
	@RequestMapping(value="/controller/getSubList.do")
	public ModelAndView getSubSelectorList(@RequestParam("singleValues") String singleValues){
		ModelAndView mav = new ModelAndView();
		
		String areaCode = singleValues;
		
		// 서브 리스트 목록 가져오는 메소드
		
		List<String> lst = new ArrayList<String>();
		if(areaCode.equals("서울")){
		lst.add("강남");
		lst.add("건대");
		lst.add("종로");
		lst.add("홍대");
		}else if(areaCode.equals("경기")){
			lst.add("부천");
			lst.add("성남");
			lst.add("용인");
			lst.add("수원");
		}else if(areaCode.equals("인천")){
			lst.add("송도");
			lst.add("연수");
			lst.add("계양");
		}else if(areaCode.equals("부산")){
			lst.add("서면");
			lst.add("해운대");
		}
		
		mav.addObject("result",lst);
		
		String viewName = "ajax_result";
		mav.setViewName(viewName);
		
		return mav;
	}
	@RequestMapping(value = "/controller/studyAreaSearch.do", method = RequestMethod.POST)
	public ModelAndView getStudyAreaSearch(int start, int end, int nowPage, Model model,
			@RequestParam("study_area")String studyArea,
			@RequestParam("study_rigion")String studyRigion){
		ModelAndView mav = new ModelAndView();
		
		List<Study> studyAreaList = StudyService.getStudyByArea(studyArea, studyRigion, start, end);
		int totalCount = StudyService.getStudyByAreaCount(studyArea, studyRigion);
		
		mav.setViewName("studyAreaSearch");
		mav.addObject("totalCount", totalCount);
		mav.addObject("studyAreaList", studyAreaList);
		
		return mav;
	}

}
