package com.college.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin")
@Controller
public class GalleryController {
	
	@GetMapping("/gallery")
	public String showGallery() {
		return "dummy";
	}

}
