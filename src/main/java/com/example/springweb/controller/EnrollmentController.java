package com.example.springweb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springweb.model.Enrollment;
import com.example.springweb.service.EnrollmentService;

@RestController
@RequestMapping("/enrollment")
public class EnrollmentController {
	
	@Autowired
	private EnrollmentService service;
	
	@PostMapping("/addEnrollment")
	public ResponseEntity<String> addEnrollment(@RequestBody Enrollment e){
		
		service.enrrollCourse(e);
		return ResponseEntity.status(201).body("Enrolled Successfully");
		
	}
	@GetMapping("/findall")
	public List<Enrollment> findallEnrollments(){
		
		
		return service.findallEnrollments();
	}
	
	public ResponseEntity<String> updateEnrollment(int id,@RequestBody Enrollment e){
		
		service.updateEnrollment(id,e);
		return null;
	}
	

}
