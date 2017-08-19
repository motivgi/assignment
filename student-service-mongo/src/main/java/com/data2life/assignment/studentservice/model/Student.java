package com.data2life.assignment.studentservice.model;

import org.springframework.data.annotation.Id;


public class Student {
	@Id
	private int id;
	private String name;
	private String address;
	private float avg;
	
	public Student(){}
	
	public Student(int id, String name, String address, float avg){
		super();
		this.name = name;
		this.address = address;
		this.id = id;
		this.avg = avg;
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

	public float getAvg()
	{
		return avg;
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
	public void setAvg(float avg)
	{
		this.avg = avg;
	}
}
