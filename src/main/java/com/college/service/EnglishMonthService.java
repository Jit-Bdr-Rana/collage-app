package com.college.service;

import java.util.List;

import com.college.model.EnglishMonth;

public interface EnglishMonthService {
	public List<EnglishMonth> showAllEnglishMonth();
	public void saveEnglishMonth(EnglishMonth englishMonth);
	public Integer countEnglishMonth();

}
