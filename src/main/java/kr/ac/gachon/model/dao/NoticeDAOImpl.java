package kr.ac.gachon.model.dao;

import java.util.HashMap;
import java.util.List;

import kr.ac.gachon.model.vo.Notice;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;

@Component("noticeDAO")
public class NoticeDAOImpl extends SqlSessionDaoSupport implements NoticeDAO{
	
	public boolean create(Notice notice){
		boolean flag = false;
		
		SqlSession session = getSqlSession();
		flag = session.insert("insertNotice", notice)>0 ? true : false;
		
		return flag;	
	}
	
	public boolean update(Notice notice){
		
		boolean flag = false;

		SqlSession session = getSqlSession();
		flag = session.update("updateNotice", notice)>0 ? true : false;
		return flag;
	}
	
	public boolean remove(int noticeNo){
		
		boolean flag = false;

		SqlSession session = getSqlSession();
		flag = session.delete("deleteNotice", noticeNo)>0 ? true : false;
		return flag;
	}
	
	public List<Notice> findAllNotice() {
		
		SqlSession session = getSqlSession();
		return session.selectList("selectAllNotice");
		
	}
	
	public Notice checkNoticeContent(int noticeNo){
		
		SqlSession session = getSqlSession();
		
		return session.selectOne("checkContent", noticeNo);
					
	}
	
	public List<Notice> findNoticeContent(String notice_content){
		
		SqlSession session = getSqlSession();
		return session.selectList("searchContent", notice_content);
	
	}
	
	public List<Notice> findNoticeTitle(String notice_title){
		
		SqlSession session = getSqlSession();
		return session.selectList("searchTitle", notice_title);
		
	}
	public List<Notice> selectNoticeTitleSearch(String noticeTitle, int start, int end){
		SqlSession session = getSqlSession();
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("noticeTitle", noticeTitle);
		map.put("start", start);
		map.put("end", end);
		
		return session.selectList("selectNoticeByTitle", map);
	}
	public List<Notice> selectNoticeContentSearch(String noticeContent, int start, int end){
		SqlSession session = getSqlSession();
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("noticeContent", noticeContent);
		map.put("start", start);
		map.put("end", end);
		
		return session.selectList("selectNoticeByContent", map);
	}
	
	public List<Notice> findNoticeContentTitle(String notice_title, String notice_content){
		
		SqlSession session = getSqlSession();
		
		HashMap<String, Object> map = new HashMap<String,Object>();
		map.put("notice_title", notice_title);
		map.put("notice_content", notice_content);
			
		return session.selectList("searchContentTitle", map);
	}
	
	public List<Notice> selectNoticeByPaging(int start,int end){
		SqlSession session = getSqlSession();
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("start", start);
		map.put("end", end);
	
		return session.selectList("selectNoticePage", map);
	}
	
	public int selectNoticeCount(){
		SqlSession session = getSqlSession();
	
		return session.selectOne("selectNoticeCount");
	}
	
	public List<Notice> selectNoticeCategory(int start, int end, String category){
		SqlSession session = getSqlSession();
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("start", start);
		map.put("end", end);
		map.put("category", category);
	
		return session.selectList("selectNoticeCategory", map);
	}
	
	public int selectTitleSearchCount(String noticeTitle){
		SqlSession session = getSqlSession();
		return session.selectOne("selectNoticeSearchCount", noticeTitle);
	}
	public int selectContentSearchCount(String noticeContent){
		SqlSession session = getSqlSession();
		return session.selectOne("selectNoticeSearchContentCount", noticeContent);
	}
}
