package com.college.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.model.Student;
import com.college.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepository stuRepo;
	 


	@Override
	public void saveStudent(Student student) {
	    this.stuRepo.save(student);
	}

	@Override
	public List<Student> getAllStudent() {
	  return this.stuRepo.findAll();
		
	}

	@Override
	public Student getStudentById(Integer id) {
		return stuRepo.getById(id);
	}

	@Override
	public List<Student> fetchStudentByYearAndProgram(String year, Integer program_id) {
		
	
		return stuRepo.getStudentByYearAndProgram(year,program_id);
		
	}

}
