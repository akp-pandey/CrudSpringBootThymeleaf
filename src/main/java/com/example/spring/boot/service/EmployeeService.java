package com.example.spring.boot.service;

import java.awt.List;

import org.springframework.stereotype.Service;

import com.example.spring.boot.model.Employee;

@Service
public interface EmployeeService {
	java.util.List<Employee> getAllEmployees();
	void saveEmployee(Employee employee);
	Employee getEmployeeById(long id);
	void deleteById(long id);

}
