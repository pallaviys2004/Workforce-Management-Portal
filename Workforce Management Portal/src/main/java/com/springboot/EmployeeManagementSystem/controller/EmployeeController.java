package com.springboot.EmployeeManagementSystem.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.EmployeeManagementSystem.entity.Employee;
import com.springboot.EmployeeManagementSystem.service.EmployeeService;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/employees")
public class EmployeeController {
	private EmployeeService eserv;

	public EmployeeController(EmployeeService eserv) {
		
		this.eserv = eserv;
	}
	@PostMapping
	public String createEmployee(@Valid @RequestBody Employee e) {
		return eserv.createEmployee(e);
	}
	@PostMapping("/{email}")
	public Employee fetchById(@PathVariable String email) {
		return eserv.fetchById(email);

	}
	@GetMapping
	public  List<Employee> fetchAllEmployee(){
		return eserv.fetchAllEmployee();
	}
	@DeleteMapping("/{email}")
	public String deleteEmployeesById(@PathVariable String email) {
		return eserv.deleteEmployeesById(email);
	}
	

}
