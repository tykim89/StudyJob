package kr.ac.gachon.model.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import kr.ac.gachon.model.service.MyStudyService;
import kr.ac.gachon.model.vo.Member;
import kr.ac.gachon.model.vo.MemberStudyParticipation;
import kr.ac.gachon.model.vo.Study;
import kr.ac.gachon.model.vo.StudyCheck;
import kr.ac.gachon.model.vo.StudyInfo;
import kr.ac.gachon.model.vo.StudyPenalty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MyStudyListController {

	private MyStudyService MyStudyService;
	
	@Autowired
	public void setMyStudyService(MyStudyService myStudyService) {
		MyStudyService = myStudyService;
	}
	
	
	//���� ���͵� ����Ʈ
	@RequestMapping(value = "/controller/getmystudylist.do", method = RequestMethod.GET)
	public ModelAndView getMyStudyList(HttpSession session, String member_id, Model model){
		
		String memberid = (String)session.getAttribute("member_id");
		
		ModelAndView mav = new ModelAndView();
		
		List<Study> myStudyList = MyStudyService.getMyStudyList(memberid);
		
		mav.setViewName("myStudyList");
		mav.addObject("myStudyList", myStudyList);

		return mav;
	}
	
	// ���� �⼮üũ
	@RequestMapping(value = "/controller/studymanagerattendendce.do", method = RequestMethod.GET)
	public ModelAndView getStudyManagerAttendendce(@RequestParam("no")int no, Model model){
		
		ModelAndView mav = new ModelAndView();
		
		
		Study studyTitle = MyStudyService.getStudyTitle(no);
		StudyPenalty getMoney =  MyStudyService.getMoneyByNum(no); 
		List<MemberStudyParticipation> getmemberId = MyStudyService.findMemberStudyParticipation2(no);
		//�ɹ����̵� �޾ƿ��� List ����(study_no ���)
		List<Member> getMemberNamePhone = new ArrayList<Member>();
		
		for(MemberStudyParticipation m : getmemberId){
			getMemberNamePhone.add(MyStudyService.findMeberNamePhon(m.getMember_id()));
		}
		//����Ƚ��
		List<Integer> getLateMoney = new ArrayList<Integer>();
		for(MemberStudyParticipation m : getmemberId){
			getLateMoney.add(MyStudyService.findAttendanceCount("1", m.getMember_id(),no));
		}
		//�Ἦ ȸ��		
		List<Integer> getAbsentMoney = new ArrayList<Integer>();
		for(MemberStudyParticipation m : getmemberId){
			getAbsentMoney.add(MyStudyService.findAttendanceCount("2", m.getMember_id(),no));
		}
		//�� ����
		List<Integer> getTotalMoney = new ArrayList<Integer>();
		for(MemberStudyParticipation m : getmemberId){
			getTotalMoney.add(MyStudyService.findSumPenalty(m.getMember_id(), no));
		}
		
		
		mav.setViewName("studyManagerAttendence");
		mav.addObject("studyTitle", studyTitle);
		mav.addObject("getMoney",getMoney);
		mav.addObject("getMemberNamePhone", getMemberNamePhone);
		mav.addObject("getLate", getLateMoney);
		mav.addObject("getAbsent", getAbsentMoney);
		mav.addObject("getTotalMoney", getTotalMoney);
		
		
		
		return mav;
	}
	
	//���� ���͵� ��������
	@RequestMapping(value = "/controller/studymanagerdate.do", method = RequestMethod.GET)
	public ModelAndView getStudyManagerDate(@RequestParam("no")int no, Model model){
		
		ModelAndView mav = new ModelAndView();
		
		Study studyTitle = MyStudyService.getStudyTitle(no);
		List<StudyInfo> studyDate = MyStudyService.getDateByStudy(no);
		
		mav.setViewName("studyManagerDate");
		mav.addObject("studyTitle", studyTitle);
		mav.addObject("studyDate", studyDate);
		
		return mav;
	}
	
	
	//���� ���͵� ����
	@RequestMapping(value = "/controller/getdatebystudyno.do", method = RequestMethod.GET)
	public ModelAndView getDateByStudy(@RequestParam("no")int no, Model model){
		
		ModelAndView mav = new ModelAndView();
		
		List<StudyInfo> studyDate = MyStudyService.getDateByStudy(no);
		
		mav.setViewName("studyManagerDate");
		mav.addObject("studyDate", studyDate);
		mav.addObject("stdno", no);
		
		return mav;
	}
	
	//���͵� �ɹ� ������
	@RequestMapping(value = "/controller/studymemberpage.do", method = RequestMethod.GET)
	public ModelAndView getStudyMemberPage(@RequestParam("no")int no, HttpSession session, Model model){

		String memberid = (String)session.getAttribute("member_id");
		
		ModelAndView mav = new ModelAndView();
		
		Study studyTitle = MyStudyService.getStudyTitle(no);
		StudyPenalty getMoney =  MyStudyService.getMoneyByNum(no); 
		//����
		int getLateMoney = MyStudyService.findAttendanceCount("1",memberid,no);
		//�Ἦ
		int getAbsentMoney = MyStudyService.findAttendanceCount("2", memberid,no);
		//�� ����
		int getTotalMoney = MyStudyService.findSumPenalty(memberid, no);

		
		mav.setViewName("memberPage");
		mav.addObject("studyTitle", studyTitle);
		mav.addObject("getMoney",getMoney);
		mav.addObject("getLate", getLateMoney);
		mav.addObject("getAbsent", getAbsentMoney);
		mav.addObject("getTotalMoney", getTotalMoney);
		
		return mav;
	}
	
	//�޷� �ҷ�����(��������)
	@RequestMapping(value = "/controller/calendar.do", method = RequestMethod.GET)
	public ModelAndView getCalendar(@RequestParam("no")int no, Model model){

		ModelAndView mav = new ModelAndView();
		
		Study studyTitle = MyStudyService.getStudyTitle(no);
		List<StudyInfo> studyDate = MyStudyService.getDateByStudy(no);
		
		mav.setViewName("calendar");
		mav.addObject("studyTitle", studyTitle);
		mav.addObject("studyDate", studyDate);
		
		return mav;
	}
	
	
	//�޷� �ҷ�����(���͵� üƮ)
		@RequestMapping(value = "/controller/calendarcheck.do", method = RequestMethod.GET)
		public ModelAndView getCalendarCheck(@RequestParam("no")int no, Model model){

			ModelAndView mav = new ModelAndView();
			
			Study studyTitle = MyStudyService.getStudyTitle(no);
			List<StudyInfo> studyDate = MyStudyService.getDateByStudy(no);
			
			mav.setViewName("calendarCheck");
			mav.addObject("studyTitle", studyTitle);
			mav.addObject("studyDate", studyDate);
			
			return mav;
		}
	
	
	
	
	//�޷� �ҷ�����(������)
	@RequestMapping(value = "/controller/calendarview.do", method = RequestMethod.GET)
	public ModelAndView getCalendarView(@RequestParam("no")int no, Model model){

		ModelAndView mav = new ModelAndView();
		
		Study studyTitle = MyStudyService.getStudyTitle(no);
		List<StudyInfo> studyDate = MyStudyService.getDateByStudy(no);
		
		mav.setViewName("calendarView");
		mav.addObject("studyTitle", studyTitle);
		mav.addObject("studyDate", studyDate);
		
		return mav;
	}
	
	
	//���͵� �̸� �ٲٱ�
	@RequestMapping(value = "/controller/titlechage.do", method = RequestMethod.POST)
	public String updateTitle(@ModelAttribute("study") Study study, @RequestParam("stdno") int stdno, Model model){
		
		study.setStudy_no(stdno);
		model.addAttribute(study);
		
		MyStudyService.updateTitle(study);
		
		return "redirect:/controller/studymanagerdate.do?no="+stdno;
	}
	
	/*//���͵� ���� �ٲٱ�
		@RequestMapping(value = "/controller/studyinfochage.do", method = RequestMethod.POST)
		public String updateStudyInfo(@ModelAttribute("studyInfo") StudyInfo studyInfo, @RequestParam("stdno") int stdno, @RequestParam("stddate") String stddate, Model model){
			
			studyInfo.setStudy_no(stdno);
			studyInfo.setMy_study_date(stddate);
			model.addAttribute(studyInfo);
			
			MyStudyService.updateStudy_Info(studyInfo);
			
			return "redirect:/controller/studymanagerdate.do?no="+stdno;
		}*/
	
		
		//���͵� ���� �ٲٱ�
		@RequestMapping(value = "/controller/penaltychage.do", method = RequestMethod.POST)
		public String updatePenalty(@ModelAttribute("studyPenalty") StudyPenalty studyPenalty, @RequestParam("stdno") int stdno, Model model){
					
			studyPenalty.setStudy_no(stdno);
			model.addAttribute(studyPenalty);
			
			MyStudyService.updateStudy_Penalty(studyPenalty);
			
			return "redirect:/controller/studymanagerattendendce.do?no="+stdno;
		}
		
		//�˾�â ������ �ҷ�����
		@RequestMapping(value ="/scaduleInput.do", method = RequestMethod.GET)
		public ModelAndView setCalenar(@RequestParam("no")int no,@RequestParam("date")String date, Model model){

			ModelAndView mav = new ModelAndView();
			List<StudyInfo> studyDate = MyStudyService.getDateByStudy(no);
			Study studyTitle = MyStudyService.getStudyTitle(no);
			
			StudyInfo studyDateInfo = MyStudyService.findStudyByDateInfo(date, no);
			
					
			mav.addObject(date);
			mav.setViewName("scaduleInput");
			mav.addObject("studyDate", studyDate);
			mav.addObject("studyDateInfo", studyDateInfo);
			mav.addObject("studyTitle", studyTitle);

			return mav;
		}
	
		//���͵� ���� �ٲٱ�
		@RequestMapping(value = "/controller/studyinfochage2.do", method = RequestMethod.POST)
		public String updateStudyInfo2(@ModelAttribute("studyInfo") StudyInfo studyInfo, @RequestParam("no") int no, @RequestParam("date") String date, Model model){
			
			studyInfo.setStudy_no(no);
			studyInfo.setMy_study_date(date);
			model.addAttribute(studyInfo);
			
			MyStudyService.updateStudy_Info(studyInfo);
			
			return "";
		}
		
		//���͵� ��¥ ����ϱ�
		@RequestMapping(value = "/controller/studyinfodelete.do", method = RequestMethod.POST)
		public String deleteStudyInfo2(@RequestParam("no") int no, @RequestParam("date") String date, Model model){
			
			MyStudyService.deleteStudy_Info(date, no);
			
			return "redirect:/controller/studymanagerdate.do?no="+no+"&date="+date;
		}
			
		
		//���͵� �߰� �ϱ�///////
		@RequestMapping(value = "/controller/createstudydate.do", method = RequestMethod.POST)
		public String createStudyDate(@ModelAttribute("studyInfo") StudyInfo studyInfo,@ModelAttribute("studyCheck") StudyCheck studyCheck,  @RequestParam("no") int no, @RequestParam("date") String date, Model model){
			
			studyInfo.setStudy_no(no);
			studyInfo.setMy_study_date(date);
			model.addAttribute(studyInfo);
			
			MyStudyService.createMyDate(studyInfo);
			
			studyCheck.setMy_study_date(date);
			studyCheck.setStudy_no(no);
			studyCheck.setPenalty(0);
			studyCheck.setAttendance_information("0");
			studyCheck.setMember_name("0");
			model.addAttribute(studyCheck);
			
			List<MemberStudyParticipation> getmemberId = MyStudyService.findMemberStudyParticipation2(no);
			
			for(MemberStudyParticipation m : getmemberId){
				studyCheck.setMember_id(m.getMember_id());
				MyStudyService.createMyStudyCheck(studyCheck);
			}
			
			
			List<Member> getMemberName = new ArrayList<Member>();
			
			for(MemberStudyParticipation m : getmemberId){
				getMemberName.add(MyStudyService.findMeberNamePhon(m.getMember_id()));
			}
			
			
			for(Member n : getMemberName){
				studyCheck.setMember_id(n.getMember_id());
				studyCheck.setMember_name(n.getMember_name());
				MyStudyService.updateStudyCheckName(studyCheck);
			}
			
			
			return "redirect:/controller/studymanagerdate.do?no="+no+"&date="+date;
		}
		
		//�ɹ��� ���͵� ���� �ҷ�����
		@RequestMapping(value ="/scaduleContent.do", method = RequestMethod.GET)
		public ModelAndView scaduleContent(@RequestParam("no")int no,@RequestParam("date")String date, Model model){

			ModelAndView mav = new ModelAndView();
			List<StudyInfo> studyDate = MyStudyService.getDateByStudy(no);
			Study studyTitle = MyStudyService.getStudyTitle(no);
			
			StudyInfo studyDateInfo = MyStudyService.findStudyByDateInfo(date, no);
					
			mav.addObject(date);
			mav.setViewName("scaduleContent");
			mav.addObject("studyDate", studyDate);
			mav.addObject("studyDateInfo", studyDateInfo);
			mav.addObject("studyTitle", studyTitle);

			return mav;
		}
		
		
		//���͵� ��¥ ����ϱ�
		@RequestMapping(value = "/controller/studychecksubmit.do", method = RequestMethod.POST)
		public String studyCheckSubmit(@ModelAttribute("studyCheck") StudyCheck studycheck, @RequestParam("memId") List<String> memId,
				@RequestParam("studydate2") String studydate2, @RequestParam("attendance_information") List<String> attendance_information,@RequestParam("no")int no, Model model) {
			
			for(int i=0; i<memId.size(); i++ ){
			studycheck.setMember_id(memId.get(i));
			studycheck.setMy_study_date(studydate2);
			studycheck.setAttendance_information(attendance_information.get(i));
			MyStudyService.updateStudyAttendanceCheck(studycheck);
			}
			
			for(int j=0; j<memId.size(); j++){
				studycheck.setMember_id(memId.get(j));
				studycheck.setMy_study_date(studydate2);
				MyStudyService.updatePenalty(studycheck);
				System.out.println(studycheck);
			}
						
			model.addAttribute(studycheck);
			
	
			return "redirect:/controller/studymanagerattendendce.do?no="+no;
		}
		
		
		//�ɹ��� ���͵� ����ϱ�
		@RequestMapping(value = "/controller/studydeletemember.do", method = RequestMethod.POST)
		public String studyDeleteMember(HttpSession session, @RequestParam("no") int no, Model model){
			
			String memberid = (String)session.getAttribute("member_id");
			
			MyStudyService.removeMyStudy(memberid, no);
			MyStudyService.removeMyStudyCheck(memberid, no);
			
			return "redirect:/controller/getmystudylist.do";
		}
		
		//���� ���� ��������
		@RequestMapping(value = "/controller/getmanagerinfo.do", method = RequestMethod.GET)
		public ModelAndView getManagerInfo(@RequestParam("id")String member_id, Model model){

			ModelAndView mav = new ModelAndView();
			
			Member member = MyStudyService.findMeberNamePhon(member_id);
			
			mav.setViewName("mamegerInfo");
			mav.addObject("member", member);
			
			return mav;
		}
}
