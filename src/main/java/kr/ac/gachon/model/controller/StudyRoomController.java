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
	
	// ���͵�� ��� ����Ʈ
	@RequestMapping(value="/controller/studyRoomList.do", method=RequestMethod.GET)
	public ModelAndView getStudyRoomList(@RequestParam(value="studyRoomCategory",  required=false) String studyRoomCategory,
										 Model model){
			
		ModelAndView mav = new ModelAndView();
			
		if(studyRoomCategory == null || studyRoomCategory.trim().length() == 0){
			studyRoomCategory = "��ü";
		}else{
			studyRoomCategory = StringUtil.toKor(studyRoomCategory);
		}
		
		if(studyRoomCategory.equals("��ü")){
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
		
	// ���͵�� ���ۼ� ������
	@RequestMapping(value="/controller/write_room", method=RequestMethod.GET)
	public String write_room(){
		return "studyRoomInsert";
	}
		
	// ���͵�� ���ۼ�
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

		String origin_image = image.getOriginalFilename();	 // getOriginalFilename() �� ���Ͽ� �����̸��� ����
//		String uri = "D:/kdb_lecture/4.servlet_jsp/workspace/studyjob_mytest/src/main/webapp/resources/images/" + origin_image;
		String uri = session.getServletContext().getRealPath("resources/images")+"/"+ origin_image;
//		System.out.println(uri);
		
		File f = new File(uri);                // File : java.io.file
		try {
		    image.transferTo(f);                // transferTo() �޼ҵ带 ����ϸ� ������ ��ο� ������ �Ϸ�
		} catch (Exception e) {
		    e.printStackTrace();
		}
			
		studyRoomService.insertStudyRoom(new StudyRoom(areaCategory, name, origin_image, info));
			
//			mav.setViewName("/controller/studyRoomList.do");
		return "redirect:/controller/studyRoomList.do";
			
	}
		
	// ���͵�� �ۻ���
	@RequestMapping(value="/controller/deleteStudyRoom.do", method=RequestMethod.GET)
	public String delete_studyRoom(
			@RequestParam("studyRoomNo") int studyRoomNo,
			Model model
			){
		studyRoomService.deleteStudyRoom(studyRoomNo);

		return "redirect:/controller/studyRoomList.do";
		}
		
}
