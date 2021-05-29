package com.college.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.college.model.Faculty;
import com.college.model.Program;
import com.college.service.ProgramService;

@Controller
public class ProgramController {
    
	@Autowired
	private ProgramService programService;
	
	@GetMapping("/program-form")
	public String showFacultyForm(Model model) {
		String po_link = "active";
		model.addAttribute("program", new Program());
		model.addAttribute("po_link", po_link);
		return "admin/program_form";
	}

	@GetMapping("/program")
	public String showFaculty(Model model) {
		String po_link = "active";
		List<Program> listPrograms = programService.showAllProgram();
		model.addAttribute("po_link", po_link);
		model.addAttribute("listPrograms", listPrograms);
		return "admin/program_table";
	}

	@PostMapping("/program/save")
	public String saveFaculty(@ModelAttribute("faculty") Program program,RedirectAttributes redirAttrs) {
		this.programService.saveProgram(program);
		redirAttrs.addFlashAttribute("success", "Program has been added Successfully!.");
		return "redirect:/program";
	}
	@GetMapping("/program/update/{id}")
	public String showUpdateForm(@PathVariable(value="id")Integer id,Model model) {
		String po_link = "active";
		Program ProgramById=programService.programFindById(id);
		model.addAttribute("program",ProgramById);
		model.addAttribute("po_link", po_link);
		return "admin/program_form";
		
	}
	@GetMapping("/program/delete/{id}")
	public String deleteFaculty(@PathVariable(value="id")Integer id,RedirectAttributes redirAttrs) {
		this.programService.deleteProgram(id);
		redirAttrs.addFlashAttribute("success", "Program has been deleted Successfully!.");
		return "redirect:/program";
	}
	
	@GetMapping("/program/findbyid")
	public String getProgram()
	{ 
		return "jit";
	}
	
	
}
