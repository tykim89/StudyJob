package kr.ac.gachon.model.service;

import java.util.List;

import kr.ac.gachon.model.vo.FreeBoard;
import kr.ac.gachon.model.vo.Notice;

public interface NoticeService {

	public List<Notice> getNoticeList();
	public Notice getNoticeByNo(int noticeNo);
	public boolean insertNotice(Notice notice);
	public boolean deleteNotice(int noticeNo);
	public List<Notice> getNoticePage(int start, int end);
	public int getNoticeCount();
	public List<Notice> getNoticeCategory(int start, int end, String category);
	public boolean editNotice(Notice notice);
	public List<Notice> getNoticeTitleSearch(String noticeTitle, int start, int end);
	public List<Notice> getNoticeContentSearch(String noticeContent, int start, int end);
	public int getNoticeTitleSearchCount(String noticeTitle);
	public int getNoticeContentSearchCount(String noticeContent);
}
