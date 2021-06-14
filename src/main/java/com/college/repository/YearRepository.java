package com.college.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.college.model.Year;

public interface YearRepository extends JpaRepository<Year, Integer> {
	
//	@Query("SELECT y FROM Year y where y.isActive=1")
//	public List<Year>  getActiveYear();

}
