package com.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.college.model.Faculty;
import com.college.model.Program;

public interface ProgramRepository extends JpaRepository<Program,Integer>{

}
