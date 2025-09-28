package com.example.springweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springweb.model.Course;
import com.example.springweb.service.CourseService;

@RestController
@RequestMapping("/Course")
public class CourseController {
	
	@Autowired
	private CourseService service;
	
	
	@PostMapping("/addCourse")
	public ResponseEntity<String> addCourse(@RequestBody Course c){
		
		service.addCourse(c);
		return ResponseEntity.status(201).body("Course add sucessfully");
		
	}
	
	@GetMapping("/findall")
	public List<Course> findall(){
		
		return service.findall();
		
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateCourse(@PathVariable String id,@RequestBody Course c){
		service.updateCourse(id,c);
		return ResponseEntity.status(200).body("Course Updated Successfullly");
	}

}
