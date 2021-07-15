package com.college.service;

import java.util.List;

import com.college.model.Week;

public interface WeekService {
	public List<Week> showAllWeek();
	public void saveWeek(Week week);
	public Integer countWeek();

}
