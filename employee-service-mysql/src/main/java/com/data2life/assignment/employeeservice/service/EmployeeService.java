package com.data2life.assignment.employeeservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.data2life.assignment.employeeservice.model.*;
import com.data2life.assignment.employeeservice.repository.*;

@Component
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	private static EmployeeService employeeService;
	
	private EmployeeService()
	{

	}
	
	public static EmployeeService createInstance()
	{
		if(employeeService == null)
			employeeService = new EmployeeService();
		return employeeService;
	}
	
	public List<Employee> retrieveAllEmployees()
	{
		List<Employee> employees = new ArrayList<Employee>();
		Iterable<Employee> empIterator = employeeRepository.findAll();
		for(Employee emp : empIterator)
		{
			employees.add(emp);
		}
		
		return employees;
	}
	
	public Employee retrieveEmployee(int employeeId)
	{
		return employeeRepository.findOne(employeeId);
	}
	
	public void deleteEmployee(int employeeId)
	{
		employeeRepository.delete(employeeId);
	}
	
	public Employee addNewEmployee(Employee newEmployee)
	{
		Employee isEmployeeExist = employeeRepository.findOne(newEmployee.getId());
		if(isEmployeeExist == null)
			return employeeRepository.save(newEmployee);
		
		return isEmployeeExist;
	}
	
	public Employee updateEmployee(int employeeId, Employee newEmployee)
	{
		Employee empToUpdate = employeeRepository.findOne(employeeId);
		if(newEmployee.getAddress() != null)
			empToUpdate.setAdress(newEmployee.getAddress());
		if(newEmployee.getName() != null)
			empToUpdate.setName(newEmployee.getName());
		return employeeRepository.save(empToUpdate);
	}
	
}