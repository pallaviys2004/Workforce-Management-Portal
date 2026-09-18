package com.springboot.EmployeeManagementSystem.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
@Service
public class EmailService {
	private final JavaMailSender jms;

	public EmailService(JavaMailSender jms) {
		this.jms = jms;
	}
	public void send(String toemail,String otp) {
		SimpleMailMessage message=new SimpleMailMessage();
		message.setFrom("monicashankar2020@gmail.com");
		message.setTo(toemail);
		message.setSubject("Otp Verification");
		message.setText("Your OTP is"+otp);
		jms.send(message);
	}
	

}
