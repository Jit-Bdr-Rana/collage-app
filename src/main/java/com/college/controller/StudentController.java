package com.college.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.college.model.Program;
import com.college.model.Student;
import com.college.model.User;
import com.college.service.ProgramService;
import com.college.service.StudentService;
import com.college.service.UserService;

@Controller
public class StudentController {

@Autowired
private StudentService studentService;

@Autowired
private ProgramService programService;

@Autowired
private UserService userService;

@GetMapping("/student/form")
public String showStudentForm(Model model) {
	String stu_link="active";
	List<Program> listPrograms = programService.showAllProgram();
	model.addAttribute("stu_link",stu_link);
	model.addAttribute("student",new Student());
	model.addAttribute("listPrograms",listPrograms);
	
	return "admin/student_form";
}
@GetMapping("/student")
public String showStudentTable(Model model) {
	List<Student> listStudents =studentService.getAllStudent();
	List<Program> listPrograms = programService.showAllProgram();
	String stu_link="active";
	model.addAttribute("stu_link",stu_link);
	model.addAttribute("listStudents",listStudents);
	model.addAttribute("listPrograms",listPrograms);
	return "admin/student_table";
			
}
@PostMapping("/student/save")
public String saveStudent(Student student,RedirectAttributes redirAttrs,HttpServletRequest request) {
	
        student.getUser().setRole("student");
	  this.studentService.saveStudent(student);
	  if(student.getId()==null)
	  {
		  redirAttrs.addFlashAttribute("success", "Program has been added Successfully!.");  
	  }else {
		  redirAttrs.addFlashAttribute("success", "Program has been Updated Successfully!.");
	  }
	 
	return "redirect:/student";
	
}
@GetMapping("/student/update/{id}")
 public String updateStudent(@PathVariable("id") Integer id,Model model ) {
	Student student=studentService.getStudentById(id);
	List<Program> listPrograms = programService.showAllProgram();
	String stu_link="active";
	model.addAttribute("stu_link",stu_link);
	model.addAttribute("student",student);
	model.addAttribute("listPrograms",listPrograms);
	return "admin/student_form";
}
@GetMapping("/student/fetch")
public String featchStudent(HttpServletRequest response,Model model) {
	String year=response.getParameter("year");
	String program=response.getParameter("program");
	if(year!=null|| program!=null) {
		List<Student> listStudents =studentService.fetchStudentByYearAndProgram(year,Integer.parseInt(program));
		model.addAttribute("listStudents",listStudents);	
	}
	
	List<Program> listPrograms = programService.showAllProgram();
	
	model.addAttribute("listPrograms",listPrograms);
	return  "admin/student_table";
}

}
