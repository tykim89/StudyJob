package kr.ac.gachon.model.service;

import java.util.List;

import kr.ac.gachon.model.dao.FreeBoardCommentDAO;
import kr.ac.gachon.model.dao.FreeBoardDAO;
import kr.ac.gachon.model.vo.FreeBoard;
import kr.ac.gachon.model.vo.FreeBoardComment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("freeBoardService")
public class FreeBoardServiceImp implements FreeBoardService {

	private FreeBoardDAO fbDao; 
	private FreeBoardCommentDAO commentDao;
	
	@Autowired
	public void setFbDao(FreeBoardDAO fbDao) {
		this.fbDao = fbDao;
	}
	@Autowired
	public void setCommentDao(FreeBoardCommentDAO commentDao) {
		this.commentDao = commentDao;
	}
	
	public List<FreeBoard> getFreeboardList(){
		return fbDao.selectByAll();
	}
	public FreeBoard getFreeboardByNo(int freeboardNo){
		return fbDao.selectByFreeboardNo(freeboardNo);
	}
	public List<FreeBoardComment> getFreeboardComment(int freeboardNo){
		return commentDao.selectCommAll(freeboardNo);
	}
	
	public boolean insertFreeboard(FreeBoard freeboard){
		return fbDao.create(freeboard);
	}
	
	public boolean insertFreeboardComm(FreeBoardComment freeboard_comm){
		return commentDao.insertCommnet(freeboard_comm);
	}
	
	public List<FreeBoard> getFreeboardPage(int start, int end){
		return fbDao.selectByPaging(start, end);
	}
	public int getFreeboardCount(){
		return fbDao.selectCount();
	}
	public List<FreeBoard> getFreeboardTitleSearch(String freeboardTitle, int start, int end){
		return fbDao.selectTitleSearch(freeboardTitle, start, end);
	}
	public int getFreeboardSearchCount(String title){
		return fbDao.selectSearchCount(title);
	}
	public boolean delectFreeboard(int freeboardNo){
		return fbDao.delete(freeboardNo);
	}
	public boolean editFreeboard(FreeBoard freeBoard){
		return fbDao.update(freeBoard);
	}
	public List<FreeBoard> getFreeboardMemberIdSearch(String memberId, int start, int end){
		return fbDao.selectMemberIdSearch(memberId, start, end);
	}
	public int getFreeboardIdSearchCount(String memberId){
		return fbDao.selectIdSearchCount(memberId);
	}
}
