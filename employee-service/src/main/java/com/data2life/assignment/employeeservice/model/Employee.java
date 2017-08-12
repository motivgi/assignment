package com.data2life.assignment.employeeservice.model;

public class Employee {

	private Long id;
	private String name;
	private String address;
	
	
	public Employee(String name, String address, Long id){
		super();
		this.name = name;
		this.address = address;
		this.id = id;
	}
	
	public Long getId()
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
	public void setId(Long id)
	{
		this.id = id;
	}
}
