package com.college.controller;

import java.sql.Date;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.college.model.Faculty;
import com.college.model.Program;
import com.college.model.Year;
import com.college.repository.YearRepository;
import com.college.service.ProgramService;
import com.college.service.YearService;

@Controller
@RequestMapping("/admin/")
public class ProgramAndYearController {
  private	long millis=System.currentTimeMillis();  
  private   Date date=new Date(millis); 
    
	@Autowired
	private ProgramService programService;
	
	@Autowired
	private YearService yearService;
	
	@GetMapping("/program-form")
	public String showFacultyForm(Model model) {
		String po_link = "active";
		model.addAttribute("program", new Program());
		model.addAttribute("po_link", po_link);
		return "admin/program_form";
	}
	@GetMapping("/year-form")
	public String showYearForm(Model model) {
		String po_link = "active";
		model.addAttribute("year", new Year());
		model.addAttribute("po_link", po_link);
		return "admin/year_form";
	}

	@GetMapping("/program-year")
	public String showFaculty(Model model) {
		String po_link = "active";
		List<Program> listPrograms = programService.showAllProgram();
		List<Year> listYears = yearService.getYear();
		model.addAttribute("po_link", po_link);
		model.addAttribute("listPrograms", listPrograms);
		model.addAttribute("listYears", listYears);
		return "admin/program_and-year_table";
	}
	
	@PostMapping("/year/save")
	public String saveYear(Year year,RedirectAttributes redirAttrs,Model model,HttpServletRequest  request) {
	     year.setCreatedAt(this.date);
	     year.setActive(false);
		this.yearService.saveYear(year);
		redirAttrs.addFlashAttribute("success", "Year has been Added Successfully!.");
		return "redirect:/admin/program-year";
		
	}

	@PostMapping("/program/save")
	public String saveProgram(Program program,RedirectAttributes redirAttrs,Model model,HttpServletRequest  request) {
	
		Program matchProgram=this.programService.fetchProgramFromName(program.getName());
		if(matchProgram==null) { 
			
			if(program.getId()==null) {
				program.setCreatedAt(date);
				this.programService.saveProgram(program);
				redirAttrs.addFlashAttribute("success", "Program has been added Successfully!.");
				return "redirect:/admin/program-year";
			}else {
				program.setUpdatedAt(date);
				this.programService.saveProgram(program);
			redirAttrs.addFlashAttribute("success", "Program has been Updated Successfully!.");
			return "redirect:/admin/program-year";
			}
		}
		else {
			 if(program.getId()==matchProgram.getId()) {
				
				 
					return "redirect:/admin/program-year";
				 
			 }else {
					String po_link = "active";
					model.addAttribute("program", program);
					model.addAttribute("po_link", po_link);
					
					model.addAttribute("nameError","program Already exists ");
					return "admin/program_form";
				 
			 }
		
		
			
		}
		
		
	}
	@GetMapping("/program/update/{id}")
	public String showUpdateForm(@PathVariable(value="id")Integer id,Model model) {
		String po_link = "active";
		Program ProgramById=programService.programFindById(id);
		model.addAttribute("program",ProgramById);
		model.addAttribute("po_link", po_link);
		return "admin/program_form";
		
	}
	@GetMapping("/year/update/{id}")
	public String showYearForm(@PathVariable(value="id")Integer id,Model model) {
		String po_link = "active";
		Year YearById=yearService.getById(id);
		model.addAttribute("year",YearById);
		model.addAttribute("po_link", po_link);
		return "admin/year_form";
		
	}
	@GetMapping("/program/delete/{id}")
	public String deleteFaculty(@PathVariable(value="id")Integer id,RedirectAttributes redirAttrs) {
		
		this.programService.deleteProgram(id);
		redirAttrs.addFlashAttribute("success", "Program has been deleted Successfully!.");
		return "redirect:/admin/program-year";
	}
	
	@GetMapping("/program/findbyid")
	public String getProgram()
	{ 
		return "jit";
	}
	
	@GetMapping("/activePassive")
	public @ResponseBody  void  activePassive(@RequestParam("id") Integer id) {
		
		Year year=this.yearService.getById(id);
		if(year.isActive()==true)
		{
			year.setActive(false);
		}
		else {
			year.setActive(true);
		}
		this.yearService.saveYear(year);
		
	}
	
	
}
