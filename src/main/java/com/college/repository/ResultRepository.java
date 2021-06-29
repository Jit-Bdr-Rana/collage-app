package com.college.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.college.model.Result;
import com.college.model.Student;

public interface ResultRepository extends JpaRepository<Result, Integer> {
	@Query("SELECT r FROM Result r where r.resultCategory.id=?1")
	List<Result> showAllResult(Integer id);
}
