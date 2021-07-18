package com.college.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.college.model.CalendarTitle;
import com.college.model.Month;
import com.college.service.CalendarService;
import com.college.service.CalendarTitleService;
import com.college.service.EnglishMonthService;
import com.college.service.MonthService;
import com.college.service.WeekService;
import com.college.service.YearService;

@Controller
@RequestMapping("/admin/calendar/title")
public class CalendarTitleController {
	
	private	long millis=System.currentTimeMillis();  
	private   Date date=new Date(millis); 
	@Autowired
	private MonthService monthService;
	
	@Autowired
	private EnglishMonthService englishMonthService;
	
	@Autowired
	private WeekService weekService;
	
	@Autowired
	private YearService yearService;
	
	@Autowired
	private CalendarService calendarService;
	
	@Autowired
	private CalendarTitleService calendarTitleService;
	
	@GetMapping(" ")
	public String  showAllCalendarTitle(Model model) {
		
		List<Month> listOfMonths=monthService.showAllMonth();
		String calender_link="active";
		model.addAttribute("calender_link",calender_link);
		model.addAttribute("listOfMonths",listOfMonths);
		return "admin/calender_title_table";
	}
	
	@GetMapping("/form")
	public String  showCalendarTitleForm(Model model) {
		List<Month> listOfMonths=monthService.showAllMonth();
		String calender_link="active";
		model.addAttribute("listOfMonths",listOfMonths);
		model.addAttribute("calender_link",calender_link);
		return "admin/calender_title_form";
	}
	
	@PostMapping("/save")
	public String  saveCalendarTitle(CalendarTitle calendarTitle) {
		
		return "redirect:/admin/calendar/title";
	}
}
