package com.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.college.model.User;

public interface UserRepository extends JpaRepository<User,Integer> {

}
