package com.data2life.assignment.employeeservice.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.data2life.assignment.employeeservice.service.*;
import com.data2life.assignment.employeeservice.model.*;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	
	@GetMapping("/employee/get/")
	public List<Employee> retrieveAllEmployees() {
		return employeeService.retrieveAllEmployees(); 	
	}
	
	@GetMapping("/employee/get/{employeeId}")
	public Employee retrieveEmployee(@PathVariable Long employeeId) {
		return employeeService.retrieveEmployee(employeeId);
	}
	
	
	@PostMapping("/employee/add")
	public ResponseEntity<Void> addNewEmployee(@RequestBody Employee newEmployee) {

		Employee employee = employeeService.addNewEmployee(newEmployee);

		if (employee == null)
			return ResponseEntity.noContent().build();

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
				"/{id}").buildAndExpand(employee.getId()).toUri();

		return ResponseEntity.created(location).build();
	}
	
	@PutMapping("/employee/update/{employeeId}")
	public Employee retrieveDetailsForCourse(@PathVariable Long employeeId, @RequestBody Employee newEmployee) {
		return employeeService.updateEmployee(employeeId, newEmployee);
	}
	
	@DeleteMapping("/employee/delete/{employeeId}")
	public Employee removeEmployee(@PathVariable Long employeeId) {
		return employeeService.deleteEmployee(employeeId);
	}
	
}
