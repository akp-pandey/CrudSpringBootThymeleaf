package com.example.spring.boot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.boot.model.Employee;
import com.example.spring.boot.repository.EmployeeRepository;

@Service 
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	EmployeeRepository repository;
	@Override
	public List<Employee> getAllEmployees() {
		return repository.findAll();
	}
	@Override
	public void saveEmployee(Employee employee) {
		repository.save(employee);
		
	}
	@Override
	public Employee getEmployeeById(long id) {
		Optional<Employee> optional=repository.findById(id);
		Employee employee=null;
		if(optional.isPresent())
		{
			employee=optional.get();
		}
		else {
			throw new RuntimeException("Employee Not Found for id"+id);
		}
		return employee;
	}
	@Override
	public void deleteById(long id) {
		repository.deleteById(id);
		
	}

}
