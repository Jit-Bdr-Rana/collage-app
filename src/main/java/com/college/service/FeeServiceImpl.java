package com.college.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.model.Fee;
import com.college.repository.FeeRepository;

@Service
public class FeeServiceImpl implements FeeService {

	private FeeRepository feeRepo;
	@Autowired
	public FeeServiceImpl(FeeRepository feeRepo) {
		this.feeRepo=feeRepo;
	}
	@Override
	public Fee saveFee(Fee fee) {
		 return this.feeRepo.save(fee);
	}
	@Override
	public Fee getFeeById(Integer id) {
		 return  feeRepo.getById(id);
	}

}
