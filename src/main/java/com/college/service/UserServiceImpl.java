package com.college.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.model.User;
import com.college.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	@Override
	public void saveUser(User user) {
		this.userRepo.save(user);		
	}

}
