package com.springboot.EmployeeManagementSystem.dto;

import lombok.Data;

@Data
public class VerifyOtpRequest {
	private String email;
	private String otp;

}
