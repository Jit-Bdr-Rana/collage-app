package com.college.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.college.model.Student;



public interface StudentRepository extends JpaRepository<Student,Integer> {

	@Query("SELECT s FROM Student s where s.registrationYear= ?1 and s.program.id=?2")
	public List<Student> getStudentByYearAndProgram(String year,Integer program_id);
}
