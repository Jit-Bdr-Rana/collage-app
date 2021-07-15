package com.college.service;

import java.util.List;

import com.college.model.Calendar;

public interface CalendarService {
  public void saveCalendar(Calendar calendar);
  public List<Calendar> showAllCalendar();
  public Calendar  findById(Integer id);
  public void deleteCalenderById(Integer id);
  public List<Calendar>  findCalendarByYearId(Integer id);
}
