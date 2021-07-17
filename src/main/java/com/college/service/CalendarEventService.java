package com.college.service;

import java.util.List;
import java.util.Map;

import com.college.model.CalendarEvent;
import com.college.model.ListMonthEvent;

public interface CalendarEventService {

	public void saveCalendarEvent(CalendarEvent calendarEvent);
	public List<CalendarEvent> getAllMonthEvent(int month);  
	public void  deleteCalendarEventByDay(int day);
	public void  deleteCalendarEventByid(int id);
	
	
}
