package com.college.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.model.Calendar;
import com.college.repository.CalendarRepository;

@Service
public class CalendarServiceImpl implements CalendarService {
	
	@Autowired
	 private CalendarRepository calendarRepository;

	@Override
	public void saveCalendar(Calendar calendar) {
		calendarRepository.save(calendar);
		
	}

	@Override
	public List<Calendar> showAllCalendar() {
		
		return calendarRepository.findAll();
	}

	@Override
	public Calendar findById(Integer id) {
		
		return calendarRepository.getById(id);
	}

	@Override
	public void deleteCalenderById(Integer id) {
		calendarRepository.deleteById(id);
		
	}

	@Override
	public List<Calendar> findCalendarByYearId(Integer id) {
		
		return calendarRepository.findCalendarByYearId(id);
	}

}
