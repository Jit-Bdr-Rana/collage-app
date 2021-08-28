package com.college.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserResultController {
	
	@GetMapping("/result")
	public String showResult(Model model) {
		String active="result";
		model.addAttribute("active",active);
		return "front/result";
	}

}
