package kr.ac.gachon.model.dao;

import java.util.HashMap;
import java.util.List;

import kr.ac.gachon.model.vo.FreeBoard;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;

@Component("freeBoardDAO")
public class FreeBoardDAOImpl extends SqlSessionDaoSupport implements FreeBoardDAO {

	public boolean create(FreeBoard freeboard){
		boolean flag = false;
		SqlSession session = getSqlSession();
		
		flag = session.insert("insertFreeBoard", freeboard) > 0 ? true	: false;
		return flag;
	}
	
	public boolean update(FreeBoard freeboard){
		boolean flag = false;
		SqlSession session = getSqlSession();
		
		flag = session.update("updateFreeBoard", freeboard) > 0 ? true : false;
		
		return flag;
	}
	
	public boolean delete(int freeboardNo){
		boolean flag = false;
		SqlSession session = getSqlSession();

		flag = session.delete("deleteFreeBoard", freeboardNo) > 0 ? true : false;
		return flag;
	}
	
	public List<FreeBoard> selectByAll(){
		SqlSession session = getSqlSession();
		
		return session.selectList("selectFreeBoardAll");
	}
	
	public FreeBoard selectByFreeboardNo(int freeboardNo){
		SqlSession session = getSqlSession();
		
		return session.selectOne("selectFreeBoardByNo", freeboardNo);
	}
	
	public List<FreeBoard> selectTitleSearch(String freeboardTitle, int start, int end){
		
		SqlSession session = getSqlSession();
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("freeboardTitle", freeboardTitle);
		map.put("start", start);
		map.put("end", end);
		
		return session.selectList("selectFreeBoardByTitle", map);
	}
	
	public List<FreeBoard> selectMemberIdSearch(String memberId, int start, int end){
		
		SqlSession session = getSqlSession();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("memberId", memberId);
		map.put("start", start);
		map.put("end", end);
		
		return session.selectList("selectFreeBoardByMemberId", map);
	}

	public List<FreeBoard> selectByPaging(int start,int end){
		SqlSession session = getSqlSession();
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("start", start);
		map.put("end", end);
	
		return session.selectList("selectFreeBoardPage", map);
	}
	public int selectCount(){
		SqlSession session = getSqlSession();
	
		return session.selectOne("selectFreeboardCount");
	}
	
	public int selectSearchCount(String title){
		SqlSession session = getSqlSession();
		return session.selectOne("selectSearchCount", title);
		
	}
	public int selectIdSearchCount(String memberId){
		SqlSession session = getSqlSession();
		return session.selectOne("selectSearchIdCount", memberId);
	}
}
