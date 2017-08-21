package com.data2life.assignment.employeeservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.data2life.assignment.employeeservice.service.*;
import com.data2life.assignment.employeeservice.model.*;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;


	@GetMapping("/employee/")
	public ResponseEntity<List<Employee>> retrieveAllEmployees() {
		List<Employee> employees = employeeService.retrieveAllEmployees();
		if(employees == null || employees.isEmpty()){
			return new ResponseEntity<List<Employee>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}

	@GetMapping("/employee/{employeeId}")
	public ResponseEntity<Employee> retrieveEmployee(@PathVariable int employeeId) {
		Employee employee = employeeService.retrieveEmployee(employeeId);
		if (employee == null) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}


	@PostMapping("/employee/")
	public ResponseEntity<Void> addNewEmployee(@RequestBody Employee newEmployee, UriComponentsBuilder ucBuilder) {
		
		Employee employee = employeeService.addNewEmployee(newEmployee);

		if (employee == null) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/employee/{id}").buildAndExpand(employee.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping("/employee/{employeeId}")
	public ResponseEntity<Employee> retrieveDetailsForCourse(@PathVariable int employeeId, @RequestBody Employee newEmployee) {

		Employee employee = employeeService.updateEmployee(employeeId, newEmployee);

		if (employee == null) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

	@DeleteMapping("/employee/{employeeId}")
	public ResponseEntity<Employee> removeEmployee(@PathVariable int employeeId) {
		Employee employee = employeeService.deleteEmployee(employeeId);

		if (employee == null) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
	}

}
