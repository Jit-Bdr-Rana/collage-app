package com.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.college.model.Week;

public interface WeekRepository extends JpaRepository<Week,Integer> {

}
