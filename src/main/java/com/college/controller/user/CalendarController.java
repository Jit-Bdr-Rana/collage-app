package com.college.controller.user;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.college.model.GroupOfDateEventMonth;
import com.college.model.Month;
import com.college.nepalidateconverter.Converter;
import com.college.service.CalendarTitleService;
import com.college.service.MonthService;

@Controller
public class CalendarController {
	@Autowired
	private MonthService monthService;
	
	@Autowired
	private CalendarTitleService calendarTitleService;
	

	@GetMapping("/calendar")
	public String  showCalendar(Model model,HttpServletRequest request) {
		List<GroupOfDateEventMonth> listGroupOfDateEventMonth=new ArrayList<>(32); 
		List<Month> monthList=monthService.showAllMonth();
	    Converter converter=new Converter();
	    int month;
	    int  currentSal;
	    
	   try {
		   month= Integer.parseInt(request.getParameter("mahina"));
		   currentSal= Integer.parseInt(request.getParameter("saal"));
		   if(month>12 || month<1) {
			   throw(new Exception());
		   }
		   if(currentSal>2078 || currentSal<2010) {
			   throw(new Exception());
		   }
		   
	   }catch(Exception e) {
		   
		   month=1;
		   currentSal=converter.getCurrentNepliYear();
	   }
	   
	  
       
       int noOfDay=converter.getNepaliMonthFromYear(currentSal, month);
       int firstDayBar=converter.getBar(currentSal, month, 1);
       int lastDayBar=converter.getBar(currentSal, month, noOfDay);
       for(int i=1;i<=noOfDay;i++) {
    	   GroupOfDateEventMonth group=new GroupOfDateEventMonth();
    	   group.setNepaliDay(i);
    	   group.setBar(converter.getBar(currentSal, month, i));
    	   group.setCalendarTitle(calendarTitleService.findCalendarTitleByYearMonthDay(currentSal, month, i));
    	   group.setEnglishDay(converter.getEnglishDate(currentSal, month, i).getDate());
    	   listGroupOfDateEventMonth.add(group);
       }
       for(GroupOfDateEventMonth c:listGroupOfDateEventMonth) {
    	   System.out.println(c);
       }
     
       model.addAttribute("currentSal", currentSal);
       model.addAttribute("currentMahina", month);
		model.addAttribute("monthList",monthList);
		model.addAttribute("noOfDay",noOfDay);
		model.addAttribute("firstDayBar",firstDayBar);
		model.addAttribute("lastDayBar",lastDayBar);
		model.addAttribute("listGroupOfDateEventMonth",listGroupOfDateEventMonth);
		
		
		
		
		return "front/calendar";
	}
	
}
