package com.college.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdmissionFeeController {
	
@GetMapping("/admisssion-fee")
public String showAdmissionFee(Model model) {
   String fee_link="active";
	model.addAttribute("fee_link",fee_link);
	return "admin/admission_fee_table";
}


}
