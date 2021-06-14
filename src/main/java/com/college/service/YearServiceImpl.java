package com.college.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.model.Year;
import com.college.repository.YearRepository;

@Service
public class YearServiceImpl implements YearService {
	@Autowired 
	  private YearRepository yearRepo;

	@Override
	public List<Year> getYear() {
		return this.yearRepo.findAll();
	}

	@Override
	public Year getById(Integer id) {
	return this.yearRepo.getById(id);
	}

	@Override
	public void saveYear(Year year) {
		 this.yearRepo.save(year);	
	}

}
