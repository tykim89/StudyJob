package kr.ac.gachon.model.dao;

import java.util.List;

import kr.ac.gachon.model.vo.Notice;

public interface NoticeDAO {

	public boolean create(Notice notice);
	public boolean update(Notice notice);
	public boolean remove(int noticeNo);	
	public List<Notice> findAllNotice();
//	public List<Notice> findNotice(String notice_main_category);
	public Notice checkNoticeContent(int noticeNo);
//	public List<Notice> findNoticeContent(String notice_content);
//	public List<Notice> findNoticeTitle(String notice_title);
//	public List<Notice> findNoticeContentTitle(String notice_title, String notice_content);
	public List<Notice> selectNoticeTitleSearch(String noticeTitle, int start, int end);
	public List<Notice> selectNoticeContentSearch(String noticeContent, int start, int end);
	public List<Notice> selectNoticeByPaging(int start,int end);
	public int selectNoticeCount();
	public List<Notice> selectNoticeCategory(int start, int end, String category);
	public int selectTitleSearchCount(String noticeTitle);
	public int selectContentSearchCount(String noticeContent);
}
