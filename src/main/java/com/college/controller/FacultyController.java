package com.college.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.college.model.Faculty;
import com.college.service.FacultyService;

@Controller
public class FacultyController {

	@Autowired
	private FacultyService facultyService;

	@GetMapping("/faculty-form")
	public String showFacultyForm(Model model) {
		String fac_link = "active";
		model.addAttribute("faculty", new Faculty());
		model.addAttribute("fac_link", fac_link);
		return "admin/faculty_form";
	}

	@GetMapping("/faculty")
	public String showFaculty(Model model) {
		String fac_link = "active";
		List<Faculty> listFaculties = facultyService.showAllFaculty();
		
		model.addAttribute("fac_link", fac_link);
		model.addAttribute("listFaculties", listFaculties);
		return "admin/faculty_table";
	}

	@PostMapping("/faculty/save")
	public String saveFaculty(@ModelAttribute("faculty") Faculty faculty,RedirectAttributes redirAttrs) {
		this.facultyService.saveFaculty(faculty);
		redirAttrs.addFlashAttribute("success", "Faculty has been added Successfully!.");
		return "redirect:/faculty";
	}
	@GetMapping("/faculty/update/{id}")
	public String showUpdateForm(@PathVariable(value="id")Integer id,Model model) {
		String fac_link = "active";
		Faculty facultyById=facultyService.facultyFindById(id);
		model.addAttribute("faculty",facultyById);
		model.addAttribute("fac_link", fac_link);
		return "admin/faculty_form";
		
	}
	@GetMapping("/faculty/delete/{id}")
	public String deleteFaculty(@PathVariable(value="id")Integer id,RedirectAttributes redirAttrs) {
		this.facultyService.deleteFaculty(id);
		redirAttrs.addFlashAttribute("success", "Faculty has been deleted Successfully!.");
		return "redirect:/faculty";
	}
}
