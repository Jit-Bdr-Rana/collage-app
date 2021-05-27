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
	public List<Student> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveStudent(Student student) {
	    this.stuRepo.save(student);
	}

}
