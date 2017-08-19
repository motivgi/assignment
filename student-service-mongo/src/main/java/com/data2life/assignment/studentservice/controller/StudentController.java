package com.data2life.assignment.studentservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.data2life.assignment.studentservice.model.*;
import com.data2life.assignment.studentservice.service.*;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/student/")
	public List<Student> retrieveAllStudents() {
		return studentService.retrieveAllStudents(); 	
	}
	
	@GetMapping("/student/{studentId}")
	public Student retrieveStudent(@PathVariable int studentId) {
		return studentService.retrieveStudent(studentId);
	}
	
	@PostMapping("/student/")
	public Student addNewStudent(@RequestBody Student newStudent) {
		return studentService.addNewStudent(newStudent);
	}
	
	@PutMapping("/student/{studentId}")
	public Student updateStudent(@PathVariable int studentId, @RequestBody Student newStudent) {
		return studentService.updateStudent(studentId, newStudent);
	}
	
	@DeleteMapping("/student/{studentId}")
	public void deleteStudent(@PathVariable int studentId) {
		studentService.deleteStudent(studentId);
	}
	
}
