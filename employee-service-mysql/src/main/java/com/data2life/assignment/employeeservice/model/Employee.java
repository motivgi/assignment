package com.data2life.assignment.employeeservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
	private int id;
	private String name;
	private String address;
	private float salary;
	
	public Employee(){}
	
	public Employee(int id, String name, String address){
		super();
		this.name = name;
		this.address = address;
		this.id = id;
	}
	
	public int getId()
	{
		return id;
	}
	public String getName()
	{
		return name;
	}
	public String getAddress()
	{
		return address;
	}
	public float getSalary()
	{
		return salary;
	}
	
	public void setAdress(String address)
	{
		this.address = address;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public void setSalary(float salary)
	{
		this.salary = salary;
	}
}
