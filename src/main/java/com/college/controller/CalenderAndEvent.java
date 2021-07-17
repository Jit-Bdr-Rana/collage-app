package com.college.controller;


import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.college.model.Calendar;
import com.college.model.CalendarEvent;
import com.college.model.CalendarList;
import com.college.model.EnglishMonth;
import com.college.model.Month;
import com.college.model.Week;
import com.college.model.Year;
import com.college.nepalidateconverter.Converter;
import com.college.nepalidateconverter.NepaliDate;
import com.college.service.CalendarEventService;
import com.college.service.CalendarService;
import com.college.service.EnglishMonthService;
import com.college.service.MonthService;
import com.college.service.WeekService;
import com.college.service.YearService;


@Controller
@RequestMapping("/admin")
public class CalenderAndEvent {
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
	private CalendarEventService calendarEventService;
	
	@GetMapping("/calender-event")
	public String showCalenderEvent(Model model,Integer month) {
		int Month=1;
		this.seedMonth();
		 Map<Integer, List<CalendarEvent>> groupingEventByDay = new HashMap<>();
		List<CalendarEvent> allMonthEvent=new ArrayList<>();
		if(month==null) {
			 allMonthEvent=calendarEventService.getAllMonthEvent(1);
		}else {
			Month=month;
			 allMonthEvent=calendarEventService.getAllMonthEvent(month);
		}
	   
		groupingEventByDay =  allMonthEvent.stream().collect(Collectors.groupingBy(CalendarEvent::getDay));
		List<Month> listOfMonths=monthService.showAllMonth();
		model.addAttribute("selectedMonth",Month);
		model.addAttribute("listOfMonths",listOfMonths);
		model.addAttribute("groupingEventByDay",groupingEventByDay);
		String calender_link="active";
		model.addAttribute("calender_link",calender_link);
		
	
		return "admin/calender_event_table";
	}
	
	@PostMapping("/calendar/event/getmonth")
	public String getEachMonthEvent(@RequestParam("month")int month,Model model) {
	  return showCalenderEvent(model, month);
	}
	
	@GetMapping("/calender/form")
	public String showCalenderEventForm(Model model) {
       CalendarEvent calendarEvent =new CalendarEvent();
		List<Month> listOfMonths=monthService.showAllMonth();
		String calender_link="active";
		int firstMonthDays=getDaysFromMonth(1);
		model.addAttribute("firstMonthDays",firstMonthDays);
		model.addAttribute("listOfMonths",listOfMonths);
		model.addAttribute("calender_link",calender_link);
		model.addAttribute("calendarEvent",calendarEvent);
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
	
	
	@PostMapping("/calendar/event/save")
	public String saveCalendarEvent(CalendarEvent calendarEvent,Model model) {
		Converter converter =new Converter();
		calendarEvent.setYear(converter.getCurrentNepliYear());
	
		calendarEventService.saveCalendarEvent(calendarEvent);
	  
		return showCalenderEvent(model,calendarEvent.getMonth().getId());
		
	}
	
	
	@GetMapping("/calendar/event/deleteById")
	public String deleteCalendarEventById(@RequestParam("month")String month,@RequestParam("id")String id,Model model) {
		if(isNumeric(month)==true && isNumeric(id)==true) {
//			calendarEventService.deleteCalendarEventByid(Integer.parseInt(id));
			return showCalenderEvent(model,Integer.parseInt(month));
		}else {
			return "redirect:admin/calendar/event/deleteById?month="+month+"&id="+id;
		}
		
		
	}
	
	public static boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        Integer d = Integer.parseInt(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	
	// api's
	@GetMapping("/event/getmonth/{id}")
    	public  @ResponseBody  int getDaysFromMonth(@PathVariable(name="id")int id) {		
		Converter converter =new Converter();
		String dateInString=date.toString();
		  String dateInArray[]=dateInString.split("-");
		  NepaliDate nepaliDate=converter.getNepaliDate(Integer.parseInt(dateInArray[0]),Integer.parseInt(dateInArray[1]),Integer.parseInt(dateInArray[2]));
		return converter.getNepaliMonthFromYear(nepaliDate.getSaal(), id);
	
	  }
  @GetMapping("/event/month/{id}")
    public @ResponseBody Map<Integer,List<CalendarEvent>> getMonthEvent(@PathVariable(name="id") int id){
	  Map<Integer, List<CalendarEvent>> groupingEventByDay = new HashMap<>();
		List<CalendarEvent> allMonthEvent=new ArrayList<>();  
	
		allMonthEvent=calendarEventService.getAllMonthEvent(3);
		groupingEventByDay =  allMonthEvent.stream().collect(Collectors.groupingBy(CalendarEvent::getDay));
		return groupingEventByDay;
	  
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
