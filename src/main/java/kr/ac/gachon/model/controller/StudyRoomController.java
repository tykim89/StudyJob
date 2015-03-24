package kr.ac.gachon.model.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpSession;

import kr.ac.gachon.model.service.StudyRoomService;
import kr.ac.gachon.model.vo.StudyRoom;
import kr.ac.gachon.util.StringUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudyRoomController {

	private StudyRoomService studyRoomService;

	@Autowired
	public void setStudyRoomService(StudyRoomService studyRoomService) {
		this.studyRoomService = studyRoomService;
	}
	
	// 스터디룸 목록 리스트
	@RequestMapping(value="/controller/studyRoomList.do", method=RequestMethod.GET)
	public ModelAndView getStudyRoomList(@RequestParam(value="studyRoomCategory",  required=false) String studyRoomCategory,
										 Model model){
			
		ModelAndView mav = new ModelAndView();
			
		if(studyRoomCategory == null || studyRoomCategory.trim().length() == 0){
			studyRoomCategory = "전체";
		}else{
			studyRoomCategory = StringUtil.toKor(studyRoomCategory);
		}
		
		if(studyRoomCategory.equals("전체")){
			List<StudyRoom> allStudyRoomList = studyRoomService.getAllStudyRoomList();
			mav.addObject("allStudyRoomList", allStudyRoomList);
			mav.setViewName("studyRoomList");
		}else{
			List<StudyRoom> categoryStudyRoomList = studyRoomService.getCategoryStudyRoomList(studyRoomCategory);
			mav.addObject("categoryStudyRoomList", categoryStudyRoomList);
			mav.setViewName("studyRoomCateList");
		}
		return mav;
	}
		
	// 스터디룸 글작성 페이지
	@RequestMapping(value="/controller/write_room", method=RequestMethod.GET)
	public String write_room(){
		return "studyRoomInsert";
	}
		
	// 스터디룸 글작성
	@RequestMapping(value="/controller/insertStudyRoom.do", method=RequestMethod.POST)
	public String write_studyRoom(
			@RequestParam("areaCategory") String areaCategory,
			@RequestParam("name") String name,
			@RequestParam("info") String info,
			@RequestParam("image") MultipartFile image,
			Model model,
			HttpSession session
			){
			System.out.println(areaCategory);
			System.out.println("1111");
//			ModelAndView mav = new ModelAndView();
			//String to = StringUtil.toKor(studyRoomCategory);

		String origin_image = image.getOriginalFilename();	 // getOriginalFilename() 를 통하여 파일이름을 얻음
//		String uri = "D:/kdb_lecture/4.servlet_jsp/workspace/studyjob_mytest/src/main/webapp/resources/images/" + origin_image;
		String uri = session.getServletContext().getRealPath("resources/images")+"/"+ origin_image;
//		System.out.println(uri);
		
		File f = new File(uri);                // File : java.io.file
		try {
		    image.transferTo(f);                // transferTo() 메소드를 사용하면 지정한 경로에 저장이 완료
		} catch (Exception e) {
		    e.printStackTrace();
		}
			
		studyRoomService.insertStudyRoom(new StudyRoom(areaCategory, name, origin_image, info));
			
//			mav.setViewName("/controller/studyRoomList.do");
		return "redirect:/controller/studyRoomList.do";
			
	}
		
	// 스터디룸 글삭제
	@RequestMapping(value="/controller/deleteStudyRoom.do", method=RequestMethod.GET)
	public String delete_studyRoom(
			@RequestParam("studyRoomNo") int studyRoomNo,
			Model model
			){
		studyRoomService.deleteStudyRoom(studyRoomNo);

		return "redirect:/controller/studyRoomList.do";
		}
		
}
