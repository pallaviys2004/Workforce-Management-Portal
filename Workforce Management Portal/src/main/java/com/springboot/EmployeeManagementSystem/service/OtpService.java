package com.springboot.EmployeeManagementSystem.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springboot.EmployeeManagementSystem.dto.VerifyOtpRequest;
import com.springboot.EmployeeManagementSystem.entity.User;
import com.springboot.EmployeeManagementSystem.exception.InvalidOtpException;
import com.springboot.EmployeeManagementSystem.exception.OtpExpiredException;
import com.springboot.EmployeeManagementSystem.exception.UserNotFoundException;
import com.springboot.EmployeeManagementSystem.exception.UserVerifiedException;
import com.springboot.EmployeeManagementSystem.repository.UserRepository;
import com.springboot.EmployeeManagementSystem.util.OtpUtil;

@Service
public class OtpService {
	private UserRepository repo;
	private EmailService eserv;

	public OtpService(UserRepository repo, EmailService eserv) {
		super();
		this.repo = repo;
		this.eserv = eserv;
	}
	public String verifyOtp(VerifyOtpRequest verifyOtpRequest) {
		Optional<User> o=repo.findByEmail(verifyOtpRequest.getEmail());
		if(o.isEmpty()) {
			throw new UserNotFoundException("no user found with email"+verifyOtpRequest.getEmail());		
		}
		User u=o.get();
		if(verifyOtpRequest.getOtp()==null) {
			return "Otp must be entered. Please enter otp";
		}
		if(u.getOtp()==null || u.getOtpExpiryTime()==null) {
			return "Otp already verified";
		}
		if(!u.getOtp().equals(verifyOtpRequest.getOtp())) {
			throw new InvalidOtpException("Otp is Invalid");
		}
		if(LocalDateTime.now().isAfter(u.getOtpExpiryTime())) {
			resendOtp(verifyOtpRequest.getEmail());
			return "Otp is Expired So otp is resent verify again";
		}
		u.setVerified(true);
		u.setOtp(null);
		u.setOtpExpiryTime(null);
		repo.save(u);
		return "Otp verification successful";
		
			

	}
	public void resendOtp(String email) {
		Optional<User> o=repo.findByEmail(email);
		if(o.isEmpty()) {
			throw new UserNotFoundException("no user found");		
		}
		User u=o.get();
		String otp=OtpUtil.generateOtp();
		u.setOtp(otp);
		eserv.send(email, otp);
		u.setOtpExpiryTime(LocalDateTime.now().plusMinutes(5));
		
		repo.save(u);	
		
	}


	
}
