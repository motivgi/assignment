package com.data2life.assignment.studentservice.controller;

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

import com.data2life.assignment.studentservice.model.*;
import com.data2life.assignment.studentservice.service.*;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/student/")
	public ResponseEntity<List<Student>> retrieveAllStudents() {
	
		List<Student> students = studentService.retrieveAllStudents();
		if(students == null || students.isEmpty()){
			return new ResponseEntity<List<Student>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
	}
	
	@GetMapping("/student/{studentId}")
	public ResponseEntity<Student> retrieveStudent(@PathVariable int studentId) {		
		Student student = studentService.retrieveStudent(studentId);
		if (student == null) {
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Student>(student, HttpStatus.OK);
		
	}
	
	@PostMapping("/student/")
	public ResponseEntity<Void> addNewStudent(@RequestBody Student newStudent, UriComponentsBuilder ucBuilder) {
		Student student = studentService.addNewStudent(newStudent);

		if (student == null) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/employee/{id}").buildAndExpand(student.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("/student/{studentId}")
	public ResponseEntity<Student> updateStudent(@PathVariable int studentId, @RequestBody Student newStudent) {
		Student student = studentService.updateStudent(studentId, newStudent);
		if (student == null) {
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}
	
	@DeleteMapping("/student/{studentId}")
	public ResponseEntity<Student> deleteStudent(@PathVariable int studentId) {
		Student student = studentService.deleteStudent(studentId);

		if (student == null) {
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
	}
	
}
