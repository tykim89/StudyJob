package kr.ac.gachon.model.dao;

import java.util.List;

import kr.ac.gachon.model.vo.Study_Comment;

public interface Study_CommentDAO {
	
	public boolean create(Study_Comment study_comment);
	public boolean update(Study_Comment study_comment);
	public boolean remove(int commentNo);
	public List<Study_Comment> findAllComment();
	public  List<Study_Comment>  findComment(int studyNo);
	

}
