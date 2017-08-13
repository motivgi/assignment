package com.data2life.assignment.employeeservice.service;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.data2life.assignment.employeeservice.model.*;

@Component
public class EmployeeService {

	private ArrayList<EmployeePojo> employeesList = new ArrayList<>();;
		
	public ArrayList<EmployeePojo> retrieveAllEmployees()
	{
		return employeesList;
	}
	
	public EmployeePojo retrieveEmployee(Long employeeId)
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
	
	public EmployeePojo deleteEmployee(Long employeeId)
	{
		EmployeePojo empToRemove = null;
		for(int i = 0; i < employeesList.size(); i++)
		{
			if(employeesList.get(i).getId() == employeeId)
			{
				empToRemove = employeesList.remove(i);
			}
		}
		return empToRemove;
	}
	
	public EmployeePojo addNewEmployee(EmployeePojo newEmployee)
	{
		for(int i = 0; i < employeesList.size(); i++)
		{
			if(employeesList.get(i).getId() == newEmployee.getId())//already exist
			{
				return employeesList.get(i);
			}
		}
		employeesList.add(newEmployee);
		return newEmployee;
	}
	
	public EmployeePojo updateEmployee(Long employeeId, EmployeePojo newEmployee)
	{
		
		EmployeePojo empToUpdate = null;
		for(int i = 0; i < employeesList.size(); i++)
		{
			if(employeesList.get(i).getId() == employeeId)
			{
				if(newEmployee.getAddress() != null)
					employeesList.get(i).setAdress(newEmployee.getAddress());
				if(newEmployee.getName() != null)
					employeesList.get(i).setName(newEmployee.getName());
				if(newEmployee.getId() != null)
					employeesList.get(i).setId(newEmployee.getId());
				empToUpdate = employeesList.get(i);
			}
		}
		
		return empToUpdate;
	}
	
}
