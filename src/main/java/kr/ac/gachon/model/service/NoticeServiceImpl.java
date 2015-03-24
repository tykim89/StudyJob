package kr.ac.gachon.model.service;

import java.util.List;

import kr.ac.gachon.model.dao.NoticeDAO;
import kr.ac.gachon.model.vo.Notice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("noticeService")
public class NoticeServiceImpl implements NoticeService {
	
	private NoticeDAO dao;
	
	@Autowired
	public void setDao(NoticeDAO dao) {
		this.dao = dao;
	}
	
	public List<Notice> getNoticeList(){
		return dao.findAllNotice();
	}
	public Notice getNoticeByNo(int noticeNo){
		return dao.checkNoticeContent(noticeNo);
	}
	public boolean insertNotice(Notice notice){
		return dao.create(notice);
	}
	public boolean deleteNotice(int noticeNo){
		return dao.remove(noticeNo);
	}
	public List<Notice> getNoticePage(int start, int end){
		return dao.selectNoticeByPaging(start, end);
	}
	public int getNoticeCount(){
		return dao.selectNoticeCount();
	}
	public List<Notice> getNoticeCategory(int start, int end, String category){
		return dao.selectNoticeCategory(start, end, category);
	}
	public boolean editNotice(Notice notice){
		return dao.update(notice);
	}
	public List<Notice> getNoticeTitleSearch(String noticeTitle, int start, int end){
		return dao.selectNoticeTitleSearch(noticeTitle, start, end);
	}
	public List<Notice> getNoticeContentSearch(String noticeContent, int start, int end){
		return dao.selectNoticeContentSearch(noticeContent, start, end);
	}
	public int getNoticeTitleSearchCount(String noticeTitle){
		return dao.selectTitleSearchCount(noticeTitle);
	}
	public int getNoticeContentSearchCount(String noticeContent){
		return dao.selectContentSearchCount(noticeContent);
	}
}
