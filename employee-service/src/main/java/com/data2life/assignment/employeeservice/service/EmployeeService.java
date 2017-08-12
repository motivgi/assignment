package com.data2life.assignment.employeeservice.service;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.data2life.assignment.employeeservice.model.*;

@Component
public class EmployeeService {

	private ArrayList<Employee> employeesList = new ArrayList<>();;
		
	public ArrayList<Employee> retrieveAllEmployees()
	{
		return employeesList;
	}
	
	public Employee retrieveEmployee(Long employeeId)
	{
		for(int i = 0; i < employeesList.size(); i++)
		{
			if(employeesList.get(i).getId() == employeeId)
			{
				return employeesList.get(i);
			}
		}
		return null;
	}
	
	public Employee deleteEmployee(Long employeeId)
	{
		Employee empToRemove = null;
		for(int i = 0; i < employeesList.size(); i++)
		{
			if(employeesList.get(i).getId() == employeeId)
			{
				empToRemove = employeesList.remove(i);
			}
		}
		return empToRemove;
	}
	
	public Employee addNewEmployee(Employee newEmployee)
	{
		for(int i = 0; i < employeesList.size(); i++)
		{
			if(employeesList.get(i).getId() == newEmployee.getId())
			{
				return null;
			}
		}
		employeesList.add(newEmployee);
		return newEmployee;
	}
	
	public Employee updateEmployee(Long employeeId, Employee newEmployee)
	{
		
		Employee empToUpdate = null;
		for(int i = 0; i < employeesList.size(); i++)
		{
			if(employeesList.get(i).getId() == employeeId)
			{
				employeesList.get(i).setAdress(newEmployee.getAddress());
				employeesList.get(i).setName(newEmployee.getName());
				employeesList.get(i).setId(newEmployee.getId());
				empToUpdate = employeesList.get(i);
			}
		}
		
		return empToUpdate;
	}
	
}
