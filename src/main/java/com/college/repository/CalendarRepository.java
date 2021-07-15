package com.college.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.college.model.Calendar;
import com.college.model.Year;

public interface CalendarRepository extends JpaRepository<Calendar, Integer> {
	@Query("SELECT c FROM Calendar c where c.year.id=?1")
	public List<Calendar>  findCalendarByYearId(Integer id);

}
