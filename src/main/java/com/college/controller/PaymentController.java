package com.college.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.college.model.Fee;
import com.college.model.Payment;
import com.college.model.Student;
import com.college.service.AdmissionFeeService;
import com.college.service.FeeService;
import com.college.service.PaymentService;
import com.college.service.SecurityFeeService;
import com.college.service.StudentService;

@Controller
@RequestMapping("/admin/payment/")
public class PaymentController {
	@Autowired
	private FeeService feeService;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private AdmissionFeeService admissionFeeService;
	
	@Autowired
	private SecurityFeeService securityFeeService;
	
	@Autowired
	private PaymentService paymentService;
	
	private	long millis=System.currentTimeMillis();  
	private   Date date=new Date(millis); 
	
	@GetMapping("/{id}")
	public String viewPaymentForm(@PathVariable(name="id") Integer id,Model model) {
		
		
		Student student=studentService.getStudentById(id);
		List<Payment> paymentlists=paymentService.getAllPaymentByFeeId(student.getFee().getId());
		
		model.addAttribute("paymentlists",paymentlists);
		model.addAttribute("student",student);
		return "admin/payment";
	}
	
  @PostMapping("/save/type-voucher")
   @ResponseBody public void  savePaymentTypeVoucher(@RequestParam("file") MultipartFile file,@RequestParam("mode") String mode,@RequestParam("amountFirst") Integer amount) {
	 
  }
  
  @PostMapping("/save/type-cash")
  @ResponseBody public Integer  savePaymentTypeCash(@RequestParam("mode") String mode,@RequestParam("amountFirst") Integer amount,@RequestParam("enteredBy") String enteredBy,@RequestParam("feeId") Integer feeId,@RequestParam("semester") Integer semester) {
	
	  Fee fee=feeService.getFeeById(feeId);
	  Payment payment=new Payment();
	  payment.setAmount(amount);
	  payment.setFee(fee);
	  payment.setCreatedAt(date);
	  payment.setMode(mode);
	  payment.setSemester(semester);
	  payment.setUser(null);
	  
	  paymentService.savePayment(payment);
	  
	  return 1;
	  
	 
	 
 }

}
