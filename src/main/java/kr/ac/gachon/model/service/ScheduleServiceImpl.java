/*package kr.ac.gachon.model.service;

import java.util.Date;
import java.util.List;

import kr.ac.gachon.util.ScheduleUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("schedule")
public class ScheduleServiceImpl implements ScheduleService {
	
	//private ScheduleDAO scheduleDao;
	
	@Autowired
	//@Resource(name="outputter")
	public void setScheduleDao(ScheduleDAO scheduleDao) {
		this.scheduleDao = scheduleDao;
	}

	@Override
	public boolean createSchedule(Schedule schedule) {
		return scheduleDao.insertSchedule(schedule);
	}

	@Override
	public boolean removeSchedule(int scNum) {
		return scheduleDao.deleteSchedule(scNum);
	}
	
	@Override
	public List<Schedule> getAllSchedule() {
		// TODO Auto-generated method stub
		return scheduleDao.getAllSchedule();
	}

	@Override
	public List<Schedule> getScheduleByDate(Date date) {
		// TODO Auto-generated method stub
		return scheduleDao.getScheduleByDate(date);
	}

	@Override
	public String createCalendar(int year, int month) {
		
		return ScheduleUtil.createSchedule(year, month);
	}
	

}
*/