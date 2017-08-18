package com.data2life.assignment.employeeservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
	private int id;
	private String name;
	private String address;
	
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
}
