package com.springboot.EmployeeManagementSystem.exception;

public class UserNotFoundException extends RuntimeException{

	public UserNotFoundException(String message) {
		super(message);
	}
	

}
