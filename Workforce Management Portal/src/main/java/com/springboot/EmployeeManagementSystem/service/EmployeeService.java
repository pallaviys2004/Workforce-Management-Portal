package com.springboot.EmployeeManagementSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springboot.EmployeeManagementSystem.entity.Employee;
import com.springboot.EmployeeManagementSystem.repository.EmployeeRepository;

@Service
public class EmployeeService {
	private EmployeeRepository erepo;

	public EmployeeService(EmployeeRepository erepo) {
		
		this.erepo = erepo;
	}
	public String createEmployee(Employee e) {
		erepo.save(e);
		return "Employee data inserted";
	}
	public Employee fetchById(String email) {
		Optional<Employee> o=erepo.findById(email);
		if(o.isPresent()) {
			return o.get();
		}
		else {
			return null;
		}
	
	}
	public  List<Employee> fetchAllEmployee(){
		return erepo.findAll();
	}
	public String deleteEmployeesById(String email) {
		erepo.deleteById(email);
		return "Employee data Deleted";
	}
	
	

}
