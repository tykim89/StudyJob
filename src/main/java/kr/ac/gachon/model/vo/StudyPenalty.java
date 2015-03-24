package kr.ac.gachon.model.vo;

public class StudyPenalty {
	private int study_no;
	private int lateness_money;
	private int absant_money;
	
	
	public StudyPenalty(int study_no, int lateness_money, int absant_money) {
		super();
		this.study_no = study_no;
		this.lateness_money = lateness_money;
		this.absant_money = absant_money;
	}


	public StudyPenalty() {
		super();
	}


	public int getStudy_no() {
		return study_no;
	}


	public void setStudy_no(int study_no) {
		this.study_no = study_no;
	}


	public int getLateness_money() {
		return lateness_money;
	}


	public void setLateness_money(int lateness_money) {
		this.lateness_money = lateness_money;
	}


	public int getAbsant_money() {
		return absant_money;
	}


	public void setAbsant_money(int absant_money) {
		this.absant_money = absant_money;
	}


	@Override
	public String toString() {
		return "StudyPenalty [study_no=" + study_no + ", lateness_money="
				+ lateness_money + ", absant_money=" + absant_money + "]";
	}
	

}
