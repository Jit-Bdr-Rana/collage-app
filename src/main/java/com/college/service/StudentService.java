package com.college.service;

import java.util.List;
import com.college.model.Student;
public interface StudentService {
	
	List<Student> getAllEmployees();
	void saveStudent(Student employee);
//	Employee getEmployeById(long id);
//	void deleteEmployeeById(long id);
//	Page<Employee> findPaginate(int pageNo,int pageSize,String sortField,String sortDirection);
}
