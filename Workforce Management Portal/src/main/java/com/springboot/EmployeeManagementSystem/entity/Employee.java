package com.springboot.EmployeeManagementSystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Entity
@Data
@Table(name = "employees")
public class Employee {
	@Id
	@Email(message="enter valid email id")
	@NotBlank(message="email should not be null,empty or space")
	private String email;
	@NotBlank(message="name should not be null,empty or space")
	private String name;
	@Positive(message="salary must ber >=0")
	private double salary;
	@NotBlank(message="department should not be null,empty or space")
	private String department;
	

}
