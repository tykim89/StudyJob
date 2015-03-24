package kr.ac.gachon.model.dao;

import java.util.List;

import kr.ac.gachon.model.vo.FreeBoard;

public interface FreeBoardDAO {
	public boolean create(FreeBoard freeboard);
	public boolean update(FreeBoard freeboard);
	public boolean delete(int freeboardNo);
	public List<FreeBoard> selectByAll();
	public FreeBoard selectByFreeboardNo(int freeboardNo);
	public List<FreeBoard> selectTitleSearch(String freeboardTitle, int start, int end);
	public List<FreeBoard> selectMemberIdSearch(String memberId, int start, int end);
	public List<FreeBoard> selectByPaging(int start,int end);
	public int selectCount();
	public int selectSearchCount(String title);
	public int selectIdSearchCount(String memberId);
}
