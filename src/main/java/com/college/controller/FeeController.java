package com.college.controller;

import java.net.http.HttpResponse;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.college.model.Fee;
import com.college.model.Program;
import com.college.model.Student;
import com.college.model.Year;
import com.college.service.ProgramService;
import com.college.service.StudentService;
import com.college.service.YearService;

@Controller
@RequestMapping("/admin")
public class FeeController {
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private ProgramService programService;
	
	@Autowired
	private YearService yearService;
	@GetMapping("/fee")
	public  String getStudentList(Model model,HttpServletRequest response) {
		List<Program> listPrograms=programService.showAllProgram();
		List<Year> listYears=yearService.getYear();
		String fee_link="active";
		model.addAttribute("listprograms",listPrograms);
		model.addAttribute("listyears",listYears);
		model.addAttribute("fee_link",fee_link);
		return findPaginated(1,"firstName","asc",model,response);
	}
	
	@GetMapping("/fee/page/{pageNo}")
	public String findPaginated(@PathVariable(value="pageNo")int pageNo ,@RequestParam("sortField") String sortField,@RequestParam("sortDir") String sortDir,Model model,HttpServletRequest response) {
		int pageSize=2;
	    List<Student> listStudents;
	    Page<Student> page;
		String year=response.getParameter("year");
		String program=response.getParameter("program");
		System.out.println(program);
		
		
		if(year==null|| program==null || program.equals("null") ) {
		
			 page=studentService.findPaginate(pageNo, pageSize,"firstName","asc");
			 listStudents=page.getContent();
			 System.out.println("null");
			
				
		}else {
			
			 page =studentService.fetchStudentByYearAndProgram(pageNo, pageSize,"firstName","asc",Integer.parseInt(year),Integer.parseInt(program));
			 listStudents=page.getContent();
			 System.out.println("not null jit");
			 model.addAttribute("year_id",Integer.parseInt(year));
			 model.addAttribute("program_id",Integer.parseInt(program));
		}
		
		
		String fee_link="active";
		List<Program> listPrograms=programService.showAllProgram();
		List<Year> listYears=yearService.getYear();
		model.addAttribute("fee_link",fee_link);
		
		model.addAttribute("listprograms",listPrograms);
		model.addAttribute("listyears",listYears);
		model.addAttribute("currentPage",pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems",page.getTotalElements());
		model.addAttribute("listStudents",listStudents);
		model.addAttribute("sortField",sortField);
		model.addAttribute("sortDir",sortDir);
		model.addAttribute("pageSize",pageSize);
		model.addAttribute("reverseSortDir",sortDir.equals("asc")?"desc":"asc");
		return "admin/fee_table";
	}
	
	@GetMapping("/fee/form/{id}")
	public String showFrom(@PathVariable(value="id") Integer id ,Model model) {
		model.addAttribute("student_id",id);
        model.addAttribute("fee",new Fee());
		return "admin/fee_form";
	}
	
	

}
