package com.college.service;

import java.util.List;

import com.college.model.Payment;

public interface PaymentService {
	
	public void savePayment(Payment payment);
	List<Payment> getAllPaymentByFeeId(Integer id);

}
