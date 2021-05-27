package com.college.service;

import java.util.List;

import com.college.model.Faculty;

public interface FacultyService {

	public void saveFaculty(Faculty faculty);
	public List<Faculty> showAllFaculty();
	public Faculty  facultyFindById(Integer id);
	public void deleteFaculty(Integer id);
	
}
