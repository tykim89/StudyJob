package kr.ac.gachon.model.dao;

import java.util.List;

import kr.ac.gachon.model.vo.FreeBoardComment;

public interface FreeBoardCommentDAO {
	public boolean insertCommnet(FreeBoardComment freeboardcomm);
	public boolean update(FreeBoardComment freeboardcomm);
	public boolean delete(int commentNo);
	public List<FreeBoardComment> selectCommAll(int freeboardNo);
}
