package com.college.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.model.EnglishMonth;
import com.college.repository.EnglishMonthRepository;

@Service
public class EnglishMonthServiceImpl implements EnglishMonthService {
@Autowired
  private EnglishMonthRepository englishMonthRepository;
	@Override
	public List<EnglishMonth> showAllEnglishMonth() {
		// TODO Auto-generated method stub
		return englishMonthRepository.findAll();
	}

	@Override
	public void saveEnglishMonth(EnglishMonth englishMonth) {
		englishMonthRepository.save(englishMonth);
		
	}

	@Override
	public Integer countEnglishMonth() {
		// TODO Auto-generated method stub
		return (int) englishMonthRepository.count();
	}

}
