package com.springboot.EmployeeManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.EmployeeManagementSystem.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,String> {

}
