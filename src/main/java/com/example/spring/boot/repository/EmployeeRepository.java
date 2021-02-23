package com.example.spring.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring.boot.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
