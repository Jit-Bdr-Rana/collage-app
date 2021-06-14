package com.college.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.college.model.Student;
public interface StudentService {
	
	List<Student> getAllStudent();
	void saveStudent(Student student);
	Student getStudentById(Integer id);
	public Page<Student> fetchStudentByYearAndProgram(int pageNo, int pageSize, String sortField, String sortDirection,Integer year_id,Integer program_id);
	 public Page<Student> findPaginate(int pageNo, int pageSize, String sortField, String sortDirection);
	 public void deleteStudentById(Integer id);
	 
	 public Student fetchStudentFromContact(String contact);
//	void deleteEmployeeById(long id);
//	Page<Employee> findPaginate(int pageNo,int pageSize,String sortField,String sortDirection);
}
