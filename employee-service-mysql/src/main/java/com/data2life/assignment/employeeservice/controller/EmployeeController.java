package com.data2life.assignment.employeeservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.data2life.assignment.employeeservice.service.*;
import com.data2life.assignment.employeeservice.model.*;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	
	@GetMapping("/employee/")
	public List<Employee> retrieveAllEmployees() {
		return employeeService.retrieveAllEmployees(); 	
	}
	
	@GetMapping("/employee/{employeeId}")
	public Employee retrieveEmployee(@PathVariable int employeeId) {
		return employeeService.retrieveEmployee(employeeId);
	}
	
	
	@PostMapping("/employee/")
	public Employee addNewEmployee(@RequestBody Employee newEmployee) {
		return employeeService.addNewEmployee(newEmployee);
	}
	
	@PutMapping("/employee/{employeeId}")
	public Employee retrieveDetailsForCourse(@PathVariable int employeeId, @RequestBody Employee newEmployee) {
		return employeeService.updateEmployee(employeeId, newEmployee);
	}
	
	@DeleteMapping("/employee/{employeeId}")
	public void removeEmployee(@PathVariable int employeeId) {
		employeeService.deleteEmployee(employeeId);
	}
	
}
