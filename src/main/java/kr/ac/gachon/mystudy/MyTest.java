package kr.ac.gachon.mystudy;


import java.util.List;

import kr.ac.gachon.model.dao.MemberDAO;
import kr.ac.gachon.model.dao.MemberDAOImpl;
import kr.ac.gachon.model.dao.MemberStudyParticipationDAO;
import kr.ac.gachon.model.dao.MemberStudyParticipationDAOImpl;
import kr.ac.gachon.model.dao.StudyCheckDAO;
import kr.ac.gachon.model.dao.StudyDAO;
import kr.ac.gachon.model.dao.StudyDAOImpl;
import kr.ac.gachon.model.dao.StudyInfoDAO;
import kr.ac.gachon.model.dao.StudyInfoDAOImpl;
import kr.ac.gachon.model.vo.Member;
import kr.ac.gachon.model.vo.MemberStudyParticipation;
import kr.ac.gachon.model.vo.Study;
import kr.ac.gachon.model.vo.StudyCheck;
import kr.ac.gachon.model.vo.StudyInfo;


public class MyTest {

	public static void main(String[] args) {
		MemberDAOImpl dao = new MemberDAOImpl();
		
////////////////////////////////////////마이 스터디 목록 불러오기/////////////////////////////////////////////////////		
		//팀장이나 팀원의 정보 불러오기
		
		/*Member d = dao.findMember("1");
		System.out.println(d);*/
		
		
		

		/*List<Member> memberList = dao.getMemberList();
		
		for(Member m : memberList){
			System.out.println(m);
			for(Study s : m.getStudyList()){
				System.out.println(s);
			}
			System.out.println("==========================================");
		}*/
		
		StudyDAOImpl dao2 = new StudyDAOImpl();
		
		/*Study d3 = dao2.findStudytitle(1);
		System.out.println(d3);*/
		
		
		//스터디 정보 가져오기
		/*List<Study> d3 = dao2.findStudy();
		for(Study s: d3){
			System.out.println(s);
		}

		/*List<Study> d3 = dao2.findStudy();
		System.out.println(d3.size());
		for(Study s: d3){
			System.out.println(s);
		}	*/
		
		
		
		MemberStudyParticipationDAOImpl dao3 = new MemberStudyParticipationDAOImpl();

		
	/*	MemberStudyParticipation d4 = dao3.findMemberStudyParticipation("1");
		System.out.println(d4);*/
		
		
		//mystudy목록 가져오기   아이디 한개만 불러옴 수정해야함........
	/*	List<Study> d5 = dao3.findParticipationListById("0");
		//System.out.println(d5.size());
		for(Study s: d5){
			System.out.println(s);
		}*/
		
				
		
////////////////////////////////////////팀장 일정관리 페이지/////////////////////////////////////////////////////		
		//해당 스터디 이름 가져오기
		/*MemberStudyParticipation d6 = dao3.findTitle("0","2");
		System.out.println(d6);*/
		
		
		
		//해당 스터디 참여인원과 회원 정보 가져오기

		/*List<MemberStudyParticipation> d6 = dao3.findByMemberCount(2);
		System.out.println(d6.size());
		for(MemberStudyParticipation s: d6){
			System.out.println(s);
		}*/
		
		
		//스터디 이름 수정하기
		/*boolean flag = dao2.updateTitle(new Study(1, "신나는 토익공부", null, null, null, null, null, null, 0, null));
		System.out.println("등록 : " +flag);*/
		
		
		
		StudyInfoDAOImpl dao4 = new StudyInfoDAOImpl();
		
		
		/*StudyInfo d6 = dao4.findStudyByDate("13/08/21");
		System.out.println(d6);*/
		
		
		
		//스터디 글에 대한 상세 날짜 불러오기
		/*List<StudyInfo> d6 = dao4.findDateByStudy(1);
		System.out.println(d6.size());
		for(StudyInfo s: d6){
			System.out.println(s);
		}*/
		
		
		//날짜 선택하기
	/*	
		boolean flag = dao4.createMyDate(new StudyInfo("13/12/26",1,"아아","가가","나나"));
		System.out.println("등록 : " + flag);
		*/
		//날짜 선택 후 상세 내용 바꾸기
		
		/*boolean flag = dao4.updateStudy_Info(new StudyInfo("13/12/25",1, "ㄴ", "ㄷ", "다"));
		System.out.println("수정 : " +flag);
		*/
		
		//날짜 취소하기(삭제)
		
		/*boolean flag = dao4.removeStudy_Info("13/12/25",1);
		System.out.println("삭제 : " +flag);
		*/
		
///////////////////////////////////////팀장_ 출석체크 페이지//////////////////////////////////////////////////////			
		
		//해당 스터디 이름 가져오기
				/*MemberStudyParticipation d6 = dao3.findTitle("1","1");
				System.out.println(d6);*/
		
		//스터디 글에 대한 상세 날짜 불러오기
				/*List<StudyInfo> d6 = dao4.findDateByStudy(1);
				System.out.println(d6.size());
				for(StudyInfo s: d6){
					System.out.println(s);
				}*/
		
		//StudyPenaltyDAO dao5 = new StudyPenaltyDAO();
		
		
		//지각비 결석비 수정하기
		
		/*boolean flag = dao5.updateStudy_Penalty(new StudyPenalty(1,600,1000));
		System.out.println("수정 : " +flag);
		*/
		
		//해당 스터디 지각비 결석비 조회
		/*StudyPenalty d7 = dao5.findMoneyByNum(1);
		System.out.println(d7);*/
		
		//StudyCheckDAO dao6 = new StudyCheckDAO();
		
		
		/*List<StudyCheck> d8 = dao6.findAllStudyCheck(1);
		System.out.println(d8.size());
		for(StudyCheck s: d8){
			System.out.println(s);
		}*/
		
		
		//특정 날짜의 회원 불러오기
		
		/*List<StudyCheck> d8 = dao6.findStudyNameByDate("13/08/22", 2);
		System.out.println(d8.size());
		for(StudyCheck s: d8){
			System.out.println(s);
		}*/
		
		
		//출석 지각 체크 + 지각비 입력받기
		//int penalty = 0;		
		// StudyPenalty - > 0: 0 1 : late, 2: absant
		/*boolean flag = dao6.updateStudyAttendanceCheck(new StudyCheck(0,"13/08/22","2","1",0,null));
		System.out.println("수정 : " +flag);*/
		
		
		//벌금 입력하기
		/*boolean flag = dao6.updatePenalty(new StudyCheck(0,"13/08/22","0",null,0,null));
		System.out.println("수정 : " +flag);*/
		
		
		
		//회원의 상세 정보 가져오기.. 
		
		//특정 회원의 지각 횟수와 결석 횟수, 총 벌금 계산
				//이름&&전화번호
				/*Member d7 = dao.findMeberNamePhon("1");
				System.out.println(d7);*/
				
				
				//지각 or 결석 카운팅
				/*List<StudyCheck> d9 = dao6.findAttendanceCount("2", "0");
				System.out.println(d9.size());
				for(StudyCheck s: d9){
					System.out.println(s);
				}*/
		
		
		
		
		
		
//////////////////////////////////////회워페이지///////////////////////////////////////////////////////////////////////////////////		
		
		//해당 스터디 이름 가져오기
				/*MemberStudyParticipation d6 = dao3.findTitle("1","1");
				System.out.println(d6);*/
		
		//스터디 취소하기
		/*boolean d6 = dao3.removeMyStudy("1","1");
		System.out.println(d6);*/
		
		
		//스터디 글에 대한 상세 날짜 불러오기
		/*List<StudyInfo> d6 = dao4.findDateByStudy(1);
		System.out.println(d6.size());
		for(StudyInfo s: d6){
			System.out.println(s);
		}*/
		
		//스터디 상세 정보 불러오기
		/*StudyInfo d6 = dao4.findStudyByDate("13/08/21");
		System.out.println(d6);*/
		
		//해당 스터디 지각비 결석비 조회
		/*StudyPenalty d7 = dao5.findMoneyByNum(1);
		System.out.println(d7);*/
		
		//특정 회원의 지각 횟수와 결석 횟수, 총 벌금 계산
		//이름&&전화번호
		/*Member d7 = dao.findMeberNamePhon("1");
		System.out.println(d7);*/
		
		
		//지각 or 결석 카운팅
		/*List<StudyCheck> d9 = dao6.findAttendanceCount("2", "0");
		System.out.println(d9.size());
		for(StudyCheck s: d9){
			System.out.println(s);
		}*/
		
		
		////total 벌글 나타내기
		/*int d10 = dao6.findSumPenalty("1");
		System.out.println(d10);*/
		
		
		
	}
	
	
	
}
