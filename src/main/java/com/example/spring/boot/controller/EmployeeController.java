package com.example.spring.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.spring.boot.model.Employee;
import com.example.spring.boot.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService service;
	@GetMapping("/")
	public String viewHome(Model model)
	{
		model.addAttribute("listEmployees",service.getAllEmployees());
		return "index";
	}
	
	@GetMapping("/newEmployeeForm")
	public String viewNewFormEmployee(Model model)
	{
		Employee employee=new Employee();
		model.addAttribute("employee",employee);
		return "new_employee";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee)
	{
		service.saveEmployee(employee);
		return "redirect:/";
	}
	
	@GetMapping("/showFormUpdate/{id}")
	public String showFormUpdate(@PathVariable (value = "id") long id,Model model)
	{
		Employee employee=service.getEmployeeById(id);
		model.addAttribute("employee",employee);
		return "update_employee";
	}
	@GetMapping("/showDeletedList/{id}")
	public String deleteEmployee(@PathVariable (value = "id") long id)
	{
		service.deleteById(id);
		return "redirect:/";
	}

}
