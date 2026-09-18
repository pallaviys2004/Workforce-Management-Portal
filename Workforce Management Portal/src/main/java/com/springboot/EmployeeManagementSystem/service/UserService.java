package com.springboot.EmployeeManagementSystem.service;

import java.time.LocalDateTime;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springboot.EmployeeManagementSystem.dto.RegisterRequest;
import com.springboot.EmployeeManagementSystem.entity.User;
import com.springboot.EmployeeManagementSystem.repository.UserRepository;
import com.springboot.EmployeeManagementSystem.util.OtpUtil;

@Service
public class UserService {
	
	private UserRepository repo;
	private EmailService eserv;
	private PasswordEncoder passwordencoder;
	
	

	public UserService(UserRepository repo, EmailService eserv, PasswordEncoder passwordencoder) {
		
		this.repo = repo;
		this.eserv = eserv;
		this.passwordencoder = passwordencoder;
	}



	public String register(RegisterRequest rr) {
		Optional<User> o=repo.findByEmail(rr.getEmail());
		if(o.isPresent()) {
			return "Email already Exists";
		}
		else {
			User u=new User();
			u.setName(rr.getName());
			u.setEmail(rr.getEmail());
			u.setPassword(passwordencoder.encode(rr.getPassword()));
			u.setRole("USER_ROLE");
			u.setVerified(false);
			String otp=OtpUtil.generateOtp();
			u.setOtp(otp);
			u.setOtpExpiryTime(LocalDateTime.now().plusMinutes(1));;
			repo.save(u);
			eserv.send(rr.getEmail(), otp);
			return "otp sent";
		}
		
		
	}

}
