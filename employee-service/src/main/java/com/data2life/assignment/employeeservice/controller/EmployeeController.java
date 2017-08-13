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
	
	
	@GetMapping("/employee/")
	public List<EmployeePojo> retrieveAllEmployees() {
		return employeeService.retrieveAllEmployees(); 	
	}
	
	@GetMapping("/employee/{employeeId}")
	public EmployeePojo retrieveEmployee(@PathVariable Long employeeId) {
		return employeeService.retrieveEmployee(employeeId);
	}
	
	
	@PostMapping("/employee/")
	public ResponseEntity<Void> addNewEmployee(@RequestBody EmployeePojo newEmployee) {

		EmployeePojo employee = employeeService.addNewEmployee(newEmployee);

		if (employee == null)
			return ResponseEntity.noContent().build();

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
				"/{id}").buildAndExpand(employee.getId()).toUri();

		return ResponseEntity.created(location).build();
	}
	
	@PutMapping("/employee/{employeeId}")
	public EmployeePojo retrieveDetailsForCourse(@PathVariable Long employeeId, @RequestBody EmployeePojo newEmployee) {
		return employeeService.updateEmployee(employeeId, newEmployee);
	}
	
	@DeleteMapping("/employee/{employeeId}")
	public EmployeePojo removeEmployee(@PathVariable Long employeeId) {
		return employeeService.deleteEmployee(employeeId);
	}
	
}
