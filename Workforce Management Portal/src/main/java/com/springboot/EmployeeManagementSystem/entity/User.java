package com.springboot.EmployeeManagementSystem.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Entity
@Table(name = "Users")
@Data
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	@Email
	@Column(unique = true)
	private String email;
	private String password;
	private String role;
	private Boolean verified;
	private String otp;
	private LocalDateTime otpExpiryTime;
	
	
	

}
