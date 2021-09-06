package com.college.controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.college.model.Program;
import com.college.service.ProgramService;

@Controller
public class UserResultController {
	@Autowired
	private ProgramService programService;
	
	@GetMapping("/result")
	public String showResult(Model model) {
		String active="result";
		model.addAttribute("active",active);
		return "front/result";
	}
	@PostMapping("/result/check")
	public String checkResult(HttpServletRequest request,Model model) {
		String email=request.getParameter("email");
		String symbolno=request.getParameter("symbolno");
		String program=request.getParameter("program");
		String semester=request.getParameter("semester");
		String term=request.getParameter("term");
		List<Program> programList=programService.showAllProgram();
		System.out.println("program="+program+"semester="+semester+"email="+email+"term="+term+"symbol="+symbolno);
		model.addAttribute("programList",programList);
		return "front/result";
	}

}
