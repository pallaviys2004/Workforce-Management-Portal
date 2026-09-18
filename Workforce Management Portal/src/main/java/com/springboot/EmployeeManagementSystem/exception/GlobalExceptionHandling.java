package com.springboot.EmployeeManagementSystem.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandling {
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> InvalidData(MethodArgumentNotValidException exception){
		List<FieldError> errors=exception.getBindingResult().getFieldErrors();
		Map<String, String>	map=new HashMap<String, String>();
		for(FieldError f:errors) {
			map.put(f.getField(),f.getDefaultMessage());
		}
		return new ResponseEntity<Map<String, String>>(map,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<String> UserNotFound(UserNotFoundException u){
		return new ResponseEntity<String>(u.getMessage(),HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(InvalidOtpException.class)
	public ResponseEntity<String> InvalidOtp(InvalidOtpException i){
		return new ResponseEntity<String>(i.getMessage(),HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(OtpExpiredException.class)
	public ResponseEntity<String> OtpExpired(OtpExpiredException o){
		return new ResponseEntity<String>(o.getMessage(),HttpStatus.REQUEST_TIMEOUT);
	}
	@ExceptionHandler(UserVerifiedException.class)
	public ResponseEntity<String> UserVerified(UserVerifiedException u){
		return new ResponseEntity<String>(u.getMessage(),HttpStatus.CONFLICT);
	}

}
