package com.college.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.college.model.Student;
import com.college.service.StudentService;

@Controller
public class StudentController {

@Autowired
private StudentService studentService;

@GetMapping("/student/form")
public String showStudentForm(Model model) {
	String stu_link="active";
	model.addAttribute("stu_link",stu_link);
	model.addAttribute("student",new Student());
	
	return "admin/student_form";
}
@GetMapping("/student")
public String showStudentTable(Model model) {
	String stu_link="active";
	model.addAttribute("stu_link",stu_link);
	return "admin/student_table";
			
}
@PostMapping("/student/save")
public String saveStudent(Student student) {
	  this.studentService.saveStudent(student);
	return "redirect:/";
}

}
