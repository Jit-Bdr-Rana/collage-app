package com.college.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.model.Week;
import com.college.repository.WeekRepository;

@Service
public class WeekServiceImpl implements WeekService {
@Autowired
  private WeekRepository weekRepository;
	@Override
	public List<Week> showAllWeek() {
		// TODO Auto-generated method stub
		return weekRepository.findAll();
	}

	@Override
	public void saveWeek(Week week) {
		weekRepository.save(week);
		
	}

	@Override
	public Integer countWeek() {
	  return (int) weekRepository.count();
	}

}
