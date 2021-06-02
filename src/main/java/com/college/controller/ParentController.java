package com.college.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.college.model.Parent;
import com.college.model.Program;
import com.college.model.Student;
import com.college.service.ParentService;
import com.college.service.ProgramService;
import com.college.service.StudentService;

@Controller
public class ParentController {
    
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private ProgramService programService;
	
	@Autowired
	private ParentService parentService;

	
	@GetMapping("/parent")
	public String showParent(Model model,HttpServletRequest response) {
		
		return findPaginated(1,"firstName","asc",model,response);
		
	}
	
	@PostMapping("/parent/save")
	public String saveParent(Parent parent) {
		this.parentService.saveParent(parent);
		return "redirect:/parent";
	}
	
	
	@GetMapping("/parent/update/{id}")
	public String updateParent(@PathVariable(name="id") Integer id,Model model) {
		String parent_link="active";
		Student student =studentService.getStudentById(id);
		
//	   if(student.getParent()==null) {
//		   Parent parent=new Parent();
//			parent.setStudent(student);
//			model.addAttribute("parent_link",parent);
//			model.addAttribute("parent",parent);
//	   }
//	   else {
//		   Parent parent=new Parent();
//		    parent.setId(student.getParent().getId());
//			parent.setStudent(student);
//			model.addAttribute("parent_link",parent);
//			model.addAttribute("parent",parent);
//		   
//	   }
	
			
		
		return "admin/parent_form";	
	}
	
	
	@GetMapping("parent/page/{pageNo}")
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
			
				
		}else {
			
			 page =studentService.fetchStudentByYearAndProgram(pageNo, pageSize,"firstName","asc",year,Integer.parseInt(program));
			 listStudents=page.getContent();
			 
			 model.addAttribute("year",year);
			 model.addAttribute("program",Integer.parseInt(program));
		}
		
		
		String parent_link="active";
		List<Program> listPrograms = programService.showAllProgram();
		model.addAttribute("parent_link",parent_link);
		
		model.addAttribute("listPrograms",listPrograms);
		model.addAttribute("currentPage",pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems",page.getTotalElements());
		model.addAttribute("listStudents",listStudents);
		model.addAttribute("sortField",sortField);
		model.addAttribute("sortDir",sortDir);
		model.addAttribute("pageSize",pageSize);
		model.addAttribute("reverseSortDir",sortDir.equals("asc")?"desc":"asc");
		return "admin/parent";
	}
	
	
}
