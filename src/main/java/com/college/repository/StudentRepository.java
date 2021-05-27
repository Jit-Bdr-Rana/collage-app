package com.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.college.model.Student;



public interface StudentRepository extends JpaRepository<Student,Integer> {

}
