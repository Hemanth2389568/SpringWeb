package com.example.springweb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.springweb.SpringwebApplication;
import com.example.springweb.dto.StudentDto;
import com.example.springweb.model.Student;
import com.example.springweb.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

    
	@Autowired
	private StudentService service;

	
//	@PostMapping("/addStudent")
//	public ResponseEntity<String> addStudent(@RequestBody StudentDto s ) {
//		service.addStudent(s);
//		return ResponseEntity.status(201).body("Student saved Successfully");
//	}
	
	@GetMapping("/findall")
	public List<Student> getStudents() {
		
		return service.findall();
		
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateStudent(@PathVariable int  id,@RequestBody Student s) {
		
		service.updateStudent(id,s);
		return ResponseEntity.status(200).body("Student details Updated Successfully");
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable int id)
	{
		service.deleteStudent(id);
		return ResponseEntity.status(200).body("Student deleted  Successfully");
	}
	
}
