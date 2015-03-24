package kr.ac.gachon.model.service;

import java.util.List;

import kr.ac.gachon.model.vo.FreeBoard;
import kr.ac.gachon.model.vo.FreeBoardComment;

public interface FreeBoardService {
	public List<FreeBoard> getFreeboardList();
	public FreeBoard getFreeboardByNo(int freeboardNo);
	public List<FreeBoardComment> getFreeboardComment(int freeboardNo);
	public boolean insertFreeboard(FreeBoard freeboard);
	public boolean insertFreeboardComm(FreeBoardComment freeboard_comm);
	public List<FreeBoard> getFreeboardPage(int start, int end);
	public int getFreeboardCount();
	public List<FreeBoard> getFreeboardTitleSearch(String freeboardTitle, int start, int end);
	public List<FreeBoard> getFreeboardMemberIdSearch(String memberId, int start, int end);
	public int getFreeboardSearchCount(String title);
	public boolean delectFreeboard(int freeboardNo);
	public boolean editFreeboard(FreeBoard freeBoard);
	public int getFreeboardIdSearchCount(String memberId);
}
