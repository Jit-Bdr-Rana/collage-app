package com.college.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.model.Parent;
import com.college.repository.ParentRepository;

@Service
public class ParentServiceImpl implements ParentService {

	 @Autowired
	 private ParentRepository parentRepository;
	@Override
	public void saveParent(Parent parent) {
		 this.parentRepository.save(parent);
		
	}

}
