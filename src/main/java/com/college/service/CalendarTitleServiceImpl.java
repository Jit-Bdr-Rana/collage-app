package com.college.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.model.CalendarTitle;
import com.college.repository.CalendarTitleRepository;

@Service
public class CalendarTitleServiceImpl implements CalendarTitleService {
	
	@Autowired 
	private CalendarTitleRepository calendarTitleRepository;

	@Override
	public void saveCalendarTitle(CalendarTitle calendarTitle) {
		calendarTitleRepository.save(calendarTitle);		
	}

	@Override
	public CalendarTitle getCalendarTitleById(Integer id) {
		return calendarTitleRepository.getById(id);
		
	}

	@Override
	public void deleteCalendarTitleById(Integer id) {
		calendarTitleRepository.deleteById(id);
		
	}

	@Override
	public List<CalendarTitle> getAllCalendarTitle() {
		return calendarTitleRepository.findAll();
	}

}
