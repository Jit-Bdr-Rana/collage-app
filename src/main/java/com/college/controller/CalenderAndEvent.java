package com.college.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.college.model.Calendar;
import com.college.model.CalendarList;
import com.college.model.EnglishMonth;
import com.college.model.Month;
import com.college.model.Week;
import com.college.model.Year;
import com.college.service.CalendarService;
import com.college.service.EnglishMonthService;
import com.college.service.MonthService;
import com.college.service.WeekService;
import com.college.service.YearService;

@Controller
@RequestMapping("/admin")
public class CalenderAndEvent {
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
	
	@GetMapping("/calender-event")
	public String showCalenderEvent(Model model) {
		this.seedMonth();
		String calender_link="active";
		model.addAttribute("calender_link",calender_link);
		return "admin/calender_event_table";
	}
	
	@GetMapping("/calender/form")
	public String showCalenderEventForm(Model model) {
		String calender_link="active";
		model.addAttribute("calender_link",calender_link);
		
		return "admin/calender_event_form";	
	}
	
	@GetMapping("/calender/setup")
	public String showCalenderSetupForm(Model model) {
		
		if(yearService.findYearByIsCalender()==null) {
			return "redirect:/admin/program-year";
		}
			
		Year year=yearService.findYearByIsCalender();
		List<Week> weekList=weekService.showAllWeek();
		List<EnglishMonth> EnglishMonthList=englishMonthService.showAllEnglishMonth();
	    String calender_link="active";
	    List<Month> listOfMonths=monthService.showAllMonth();
	    CalendarList calendarList=new CalendarList();
	    
	    	if(calendarService.findCalendarByYearId(year.getId()).isEmpty()) {
	    		for(Month month:listOfMonths) {
					 Calendar calendar=new Calendar();
					 calendar.setMonth(month);
					 calendarList.addCalendar(calendar);
				}
				calendarList.setYearId(year.getId());
	    		
	    	}else {
	    		for(Calendar calendar:calendarService.findCalendarByYearId(year.getId())) {
	    		 calendarList.addCalendar(calendar);
	   			 
	    		}
	    		calendarList.setYearId(year.getId());
	    	}
	    	
	


	    
	    
				
		model.addAttribute("calender_link",calender_link);
		model.addAttribute("listOfMonths",listOfMonths);
		model.addAttribute("weekList",weekList);
		model.addAttribute("EnglishMonthList",EnglishMonthList);
		model.addAttribute("calendarList",calendarList);
		
	
			return "admin/setup_calender_form";	
		
		
	}
	
	@PostMapping("/calendar/save")
	public String saveCalendar(CalendarList calendarList,Model model) {
		
		Year year=yearService.getById(calendarList.getYearId());
		for(Calendar calendar:calendarList.getCalenders()) {
			calendar.setYear(year);
			calendarService.saveCalendar(calendar);
		}
		
		return "redirect:/admin/calender-event";
		
	}
	
	public void seedMonth() {
		if(monthService.countMonth()<=0) {
			monthService.saveMonth(new Month("Baishak"));	
			monthService.saveMonth(new Month("Jesth"));	
			monthService.saveMonth(new Month("Aasar"));	
			monthService.saveMonth(new Month("Shrawn"));	
			monthService.saveMonth(new Month("Bhadra"));	
			monthService.saveMonth(new Month("Asoj"));	
			monthService.saveMonth(new Month("Kartik"));	
			monthService.saveMonth(new Month("Mangsir"));	
			monthService.saveMonth(new Month("Poush"));	
			monthService.saveMonth(new Month("Magh"));	
			monthService.saveMonth(new Month("Falgun"));	
			monthService.saveMonth(new Month("Chaitra"));	
		}
		
   if(weekService.countWeek()<=0) {
	   weekService.saveWeek(new Week("Sunday"));
	   weekService.saveWeek(new Week("Monday"));
	   weekService.saveWeek(new Week("Tuesday"));
	   weekService.saveWeek(new Week("Wednesday"));
	   weekService.saveWeek(new Week("Thrusday"));
	   weekService.saveWeek(new Week("Friday"));
	   weekService.saveWeek(new Week("Saturday"));
   }
   
   if(englishMonthService.countEnglishMonth()<=0) {
	   englishMonthService.saveEnglishMonth(new EnglishMonth("January"));
	   englishMonthService.saveEnglishMonth(new EnglishMonth("February"));
	   englishMonthService.saveEnglishMonth(new EnglishMonth("March"));
	   englishMonthService.saveEnglishMonth(new EnglishMonth("April"));
	   englishMonthService.saveEnglishMonth(new EnglishMonth("May"));
	   englishMonthService.saveEnglishMonth(new EnglishMonth("June"));
	   englishMonthService.saveEnglishMonth(new EnglishMonth("July"));
	   englishMonthService.saveEnglishMonth(new EnglishMonth("August"));
	   englishMonthService.saveEnglishMonth(new EnglishMonth("September"));
	   englishMonthService.saveEnglishMonth(new EnglishMonth("October"));
	   englishMonthService.saveEnglishMonth(new EnglishMonth("November"));
	   englishMonthService.saveEnglishMonth(new EnglishMonth("December"));
   }
		
	}
	

}
