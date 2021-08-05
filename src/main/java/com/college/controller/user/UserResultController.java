package com.college.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserResultController {
	
	@GetMapping("/result")
	public String showResult() {
		return "front/result";
	}

}
