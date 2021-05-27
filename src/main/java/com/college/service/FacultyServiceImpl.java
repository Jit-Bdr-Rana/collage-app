package com.college.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.model.Faculty;
import com.college.repository.FacultyRepository;
@Service
public class FacultyServiceImpl implements FacultyService {

	
	@Autowired
	private FacultyRepository facultyRepo;
	@Override
	public void saveFaculty(Faculty faculty) {
		this.facultyRepo.save(faculty);
		
	}
	@Override
	public List<Faculty> showAllFaculty() {
	  return	this.facultyRepo.findAll();
	
	}
	@Override
	public Faculty facultyFindById(Integer id) {
		 return facultyRepo.getById(id);
	}
	@Override
	public void deleteFaculty(Integer id) {
		
		this.facultyRepo.deleteById(id);
		
	}

}
