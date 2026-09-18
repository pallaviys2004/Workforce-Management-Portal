package com.springboot.EmployeeManagementSystem.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.EmployeeManagementSystem.dto.RegisterRequest;
import com.springboot.EmployeeManagementSystem.dto.VerifyOtpRequest;
import com.springboot.EmployeeManagementSystem.service.OtpService;
import com.springboot.EmployeeManagementSystem.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private UserService serv;
	private OtpService otpserv;
	
	public UserController(UserService serv, OtpService otpserv) {
		
		this.serv = serv;
		this.otpserv = otpserv;
	}
	@PostMapping("/register")
	public String register(@RequestBody RegisterRequest rr) {
		return serv.register(rr);
		
	}
	@PostMapping("/verify-otp")
	public String verifyOtp(@RequestBody VerifyOtpRequest verifyOtpRequest) {
		return otpserv.verifyOtp(verifyOtpRequest);
		
	}

}
