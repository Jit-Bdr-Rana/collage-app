package com.college.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.model.CalendarEvent;
import com.college.model.ListMonthEvent;
import com.college.repository.CalendarEventRepository;

@Service
public class CalendarEventServiceImpl implements CalendarEventService {
    @Autowired
    private CalendarEventRepository calendarEventRepository;
	
	@Override
	public void saveCalendarEvent(CalendarEvent calendarEvent) {
		calendarEventRepository.save(calendarEvent);
	}

	@Override
	public List<CalendarEvent> getAllMonthEvent(int month) {
	
		return calendarEventRepository.getAllMonthEvent(month);
	}

	@Override
	public void deleteCalendarEventByDay(int day) {
		calendarEventRepository.deleteCalendarEventByDay(day);
		
	}

	@Override
	public void deleteCalendarEventByid(int id) {
		calendarEventRepository.deleteById(id);
		
	}

	@Override
	public CalendarEvent getCalendarEventById(Integer id) {
		
		return 	calendarEventRepository.findById(id).get();
	}

	

}
