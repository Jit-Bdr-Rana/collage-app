package com.college.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.model.Payment;
import com.college.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;
	
	
	@Override
	public void savePayment(Payment payment) {
		
		paymentRepository.save(payment);
		
	}


	@Override
	public List<Payment> getAllPaymentByFeeId(Integer id) {
		
		return paymentRepository.fetchAllPaymentByFeeId(id);
	}

}
