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
		
////////////////////////////////////////���� ���͵� ��� �ҷ�����/////////////////////////////////////////////////////		
		//�����̳� ������ ���� �ҷ�����
		
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
		
		
		//���͵� ���� ��������
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
		
		
		//mystudy��� ��������   ���̵� �Ѱ��� �ҷ��� �����ؾ���........
	/*	List<Study> d5 = dao3.findParticipationListById("0");
		//System.out.println(d5.size());
		for(Study s: d5){
			System.out.println(s);
		}*/
		
				
		
////////////////////////////////////////���� �������� ������/////////////////////////////////////////////////////		
		//�ش� ���͵� �̸� ��������
		/*MemberStudyParticipation d6 = dao3.findTitle("0","2");
		System.out.println(d6);*/
		
		
		
		//�ش� ���͵� �����ο��� ȸ�� ���� ��������

		/*List<MemberStudyParticipation> d6 = dao3.findByMemberCount(2);
		System.out.println(d6.size());
		for(MemberStudyParticipation s: d6){
			System.out.println(s);
		}*/
		
		
		//���͵� �̸� �����ϱ�
		/*boolean flag = dao2.updateTitle(new Study(1, "�ų��� ���Ͱ���", null, null, null, null, null, null, 0, null));
		System.out.println("��� : " +flag);*/
		
		
		
		StudyInfoDAOImpl dao4 = new StudyInfoDAOImpl();
		
		
		/*StudyInfo d6 = dao4.findStudyByDate("13/08/21");
		System.out.println(d6);*/
		
		
		
		//���͵� �ۿ� ���� �� ��¥ �ҷ�����
		/*List<StudyInfo> d6 = dao4.findDateByStudy(1);
		System.out.println(d6.size());
		for(StudyInfo s: d6){
			System.out.println(s);
		}*/
		
		
		//��¥ �����ϱ�
	/*	
		boolean flag = dao4.createMyDate(new StudyInfo("13/12/26",1,"�ƾ�","����","����"));
		System.out.println("��� : " + flag);
		*/
		//��¥ ���� �� �� ���� �ٲٱ�
		
		/*boolean flag = dao4.updateStudy_Info(new StudyInfo("13/12/25",1, "��", "��", "��"));
		System.out.println("���� : " +flag);
		*/
		
		//��¥ ����ϱ�(����)
		
		/*boolean flag = dao4.removeStudy_Info("13/12/25",1);
		System.out.println("���� : " +flag);
		*/
		
///////////////////////////////////////����_ �⼮üũ ������//////////////////////////////////////////////////////			
		
		//�ش� ���͵� �̸� ��������
				/*MemberStudyParticipation d6 = dao3.findTitle("1","1");
				System.out.println(d6);*/
		
		//���͵� �ۿ� ���� �� ��¥ �ҷ�����
				/*List<StudyInfo> d6 = dao4.findDateByStudy(1);
				System.out.println(d6.size());
				for(StudyInfo s: d6){
					System.out.println(s);
				}*/
		
		//StudyPenaltyDAO dao5 = new StudyPenaltyDAO();
		
		
		//������ �Ἦ�� �����ϱ�
		
		/*boolean flag = dao5.updateStudy_Penalty(new StudyPenalty(1,600,1000));
		System.out.println("���� : " +flag);
		*/
		
		//�ش� ���͵� ������ �Ἦ�� ��ȸ
		/*StudyPenalty d7 = dao5.findMoneyByNum(1);
		System.out.println(d7);*/
		
		//StudyCheckDAO dao6 = new StudyCheckDAO();
		
		
		/*List<StudyCheck> d8 = dao6.findAllStudyCheck(1);
		System.out.println(d8.size());
		for(StudyCheck s: d8){
			System.out.println(s);
		}*/
		
		
		//Ư�� ��¥�� ȸ�� �ҷ�����
		
		/*List<StudyCheck> d8 = dao6.findStudyNameByDate("13/08/22", 2);
		System.out.println(d8.size());
		for(StudyCheck s: d8){
			System.out.println(s);
		}*/
		
		
		//�⼮ ���� üũ + ������ �Է¹ޱ�
		//int penalty = 0;		
		// StudyPenalty - > 0: 0 1 : late, 2: absant
		/*boolean flag = dao6.updateStudyAttendanceCheck(new StudyCheck(0,"13/08/22","2","1",0,null));
		System.out.println("���� : " +flag);*/
		
		
		//���� �Է��ϱ�
		/*boolean flag = dao6.updatePenalty(new StudyCheck(0,"13/08/22","0",null,0,null));
		System.out.println("���� : " +flag);*/
		
		
		
		//ȸ���� �� ���� ��������.. 
		
		//Ư�� ȸ���� ���� Ƚ���� �Ἦ Ƚ��, �� ���� ���
				//�̸�&&��ȭ��ȣ
				/*Member d7 = dao.findMeberNamePhon("1");
				System.out.println(d7);*/
				
				
				//���� or �Ἦ ī����
				/*List<StudyCheck> d9 = dao6.findAttendanceCount("2", "0");
				System.out.println(d9.size());
				for(StudyCheck s: d9){
					System.out.println(s);
				}*/
		
		
		
		
		
		
//////////////////////////////////////ȸ��������///////////////////////////////////////////////////////////////////////////////////		
		
		//�ش� ���͵� �̸� ��������
				/*MemberStudyParticipation d6 = dao3.findTitle("1","1");
				System.out.println(d6);*/
		
		//���͵� ����ϱ�
		/*boolean d6 = dao3.removeMyStudy("1","1");
		System.out.println(d6);*/
		
		
		//���͵� �ۿ� ���� �� ��¥ �ҷ�����
		/*List<StudyInfo> d6 = dao4.findDateByStudy(1);
		System.out.println(d6.size());
		for(StudyInfo s: d6){
			System.out.println(s);
		}*/
		
		//���͵� �� ���� �ҷ�����
		/*StudyInfo d6 = dao4.findStudyByDate("13/08/21");
		System.out.println(d6);*/
		
		//�ش� ���͵� ������ �Ἦ�� ��ȸ
		/*StudyPenalty d7 = dao5.findMoneyByNum(1);
		System.out.println(d7);*/
		
		//Ư�� ȸ���� ���� Ƚ���� �Ἦ Ƚ��, �� ���� ���
		//�̸�&&��ȭ��ȣ
		/*Member d7 = dao.findMeberNamePhon("1");
		System.out.println(d7);*/
		
		
		//���� or �Ἦ ī����
		/*List<StudyCheck> d9 = dao6.findAttendanceCount("2", "0");
		System.out.println(d9.size());
		for(StudyCheck s: d9){
			System.out.println(s);
		}*/
		
		
		////total ���� ��Ÿ����
		/*int d10 = dao6.findSumPenalty("1");
		System.out.println(d10);*/
		
		
		
	}
	
	
	
}
