package com.college.service;

import java.util.List;
import com.college.model.Student;
public interface StudentService {
	
	List<Student> getAllStudent();
	void saveStudent(Student employee);
	Student getStudentById(Integer id);
	 List<Student> fetchStudentByYearAndProgram(String year,Integer program_id);
//	void deleteEmployeeById(long id);
//	Page<Employee> findPaginate(int pageNo,int pageSize,String sortField,String sortDirection);
}
