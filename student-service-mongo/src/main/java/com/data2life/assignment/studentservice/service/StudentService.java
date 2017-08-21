package com.data2life.assignment.studentservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.data2life.assignment.studentservice.model.*;
import com.data2life.assignment.studentservice.repository.*;

@Component
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	private static StudentService studentService;
	
	private StudentService()
	{

	}
	
	public synchronized static StudentService createInstance()
	{
		if(studentService == null)
			studentService = new StudentService();
		return studentService;
	}
	
	public List<Student> retrieveAllStudents()
	{
		List<Student> students = new ArrayList<Student>();
		Iterable<Student> stuIterator = studentRepository.findAll();
		for(Student stu : stuIterator)
		{
			students.add(stu);
		}
		
		return students;
	}
	
	public Student retrieveStudent(int studentId)
	{
		return studentRepository.findOne(studentId);
	}
	
	public Student deleteStudent(int studentId)
	{		
		Student studentToDelete = studentRepository.findOne(studentId);
		if(studentToDelete != null)
			studentRepository.delete(studentId);
		return studentToDelete;
	}
	
	public Student addNewStudent(Student newStudent)
	{
		Student isStudentExist = studentRepository.findOne(newStudent.getId());
		if(isStudentExist == null)
			return studentRepository.save(newStudent);
		
		return null;
	}
	
	public Student updateStudent(int studentId, Student newStudent)
	{
		Student stuToUpdate = studentRepository.findOne(studentId);
		if(stuToUpdate != null)
		{
			if(newStudent.getAddress() != null)
				stuToUpdate.setAdress(newStudent.getAddress());
			if(newStudent.getName() != null)
				stuToUpdate.setName(newStudent.getName());
			if(newStudent.getAvg() != 0)
				stuToUpdate.setAvg(newStudent.getAvg());
			studentRepository.save(stuToUpdate);
		}
		return stuToUpdate;
	}
	
}
