package com.college.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class CalenderAndEvent {
	
	@GetMapping("/calender-event")
	public String showCalenderEvent(Model model) {
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
		String calender_link="active";
		model.addAttribute("calender_link",calender_link);
		return "admin/setup_calender_form";
	}
	

}
