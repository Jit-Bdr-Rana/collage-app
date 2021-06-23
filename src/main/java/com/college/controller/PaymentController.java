package com.college.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

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
	
	public static String uploadDirectory=System.getProperty("user.dir")+"/src/main/resources/static/admin/voucher";	
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
		List<Payment> paymentlistsFirst=paymentService.getAllPaymentByFeeIdAndSemester(student.getFee().getId(),1);
		List<Payment> paymentlistsSecond=paymentService.getAllPaymentByFeeIdAndSemester(student.getFee().getId(),2);
		List<Payment> paymentlistsThird=paymentService.getAllPaymentByFeeIdAndSemester(student.getFee().getId(),3);
		List<Payment> paymentlistsFourth=paymentService.getAllPaymentByFeeIdAndSemester(student.getFee().getId(),4);
		List<Payment> paymentlistsSeventh=paymentService.getAllPaymentByFeeIdAndSemester(student.getFee().getId(),7);
		List<Payment> paymentlistsFifth=paymentService.getAllPaymentByFeeIdAndSemester(student.getFee().getId(),5);
		List<Payment> paymentlistsSixth=paymentService.getAllPaymentByFeeIdAndSemester(student.getFee().getId(),6);
		List<Payment> paymentlistsEighth=paymentService.getAllPaymentByFeeIdAndSemester(student.getFee().getId(),8);
		
		model.addAttribute("paymentlistsFirst",paymentlistsFirst);
		model.addAttribute("paymentlistsSecond",paymentlistsSecond);
		model.addAttribute("paymentlistsThird",paymentlistsThird);
		model.addAttribute("paymentlistsFourth",paymentlistsFourth);
		model.addAttribute("paymentlistsFifth",paymentlistsFifth);
		model.addAttribute("paymentlistsSixth",paymentlistsSixth);
		model.addAttribute("paymentlistsSeventh",paymentlistsSeventh);
		model.addAttribute("paymentlistsEighth",paymentlistsEighth);
		model.addAttribute("student",student);
		return "admin/payment";
	}
	
  @PostMapping("/save/type-voucher")
   @ResponseBody public Payment  savePaymentTypeVoucher(@RequestParam("file") MultipartFile file,@RequestParam("mode") String mode,@RequestParam("amount") Integer amount,@RequestParam("enteredBy") String enteredBy,@RequestParam("feeId") Integer feeId,@RequestParam("semester") Integer semester) {
	  Fee fee=feeService.getFeeById(feeId);
	  Payment payment=new Payment();
	  payment.setAmount(amount);
	  payment.setFee(fee);
	  payment.setCreatedAt(date);
	  payment.setMode(mode);
	  payment.setSemester(semester);
	  payment.setUser(null);
	  
	  
	  
	  if(file.isEmpty()) {
			
		}else{
				String fileName = System.currentTimeMillis()
					+ file.getOriginalFilename().substring(file.getOriginalFilename().length() - 4);
			Path fileAndPath = Paths.get(uploadDirectory, fileName);
			try {
				Files.write(fileAndPath, file.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		payment.setVoucher(fileName);
		
		 	
		}
	  Payment payReturn= paymentService.savePayment(payment);
		 Payment paymentResponse=new Payment();
		     paymentResponse.setAmount(payReturn.getAmount());
		     paymentResponse.setCreatedAt(payReturn.getCreatedAt());
		     paymentResponse.setMode(payReturn.getMode());
		      return paymentResponse ;
		 
	 
  }
  
  @PostMapping("/save/type-cash")
  @ResponseBody public Payment  savePaymentTypeCash(@RequestParam("mode") String mode,@RequestParam("amount") Integer amount,@RequestParam("enteredBy") String enteredBy,@RequestParam("feeId") Integer feeId,@RequestParam("semester") Integer semester) {
	
	  Fee fee=feeService.getFeeById(feeId);
	  Payment payment=new Payment();
	  payment.setAmount(amount);
	  payment.setFee(fee);
	  payment.setCreatedAt(date);
	  payment.setMode(mode);
	  payment.setSemester(semester);
	  payment.setUser(null);
	  
	  Payment payReturn= paymentService.savePayment(payment);
	 Payment paymentResponse=new Payment();
	     paymentResponse.setAmount(payReturn.getAmount());
	     paymentResponse.setCreatedAt(payReturn.getCreatedAt());
	     paymentResponse.setMode(payReturn.getMode());
	     
	  
	 
			  return paymentResponse ;
	 
 }

}
