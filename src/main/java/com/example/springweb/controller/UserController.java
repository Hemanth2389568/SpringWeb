package com.example.springweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springweb.dto.StudentDto;
import com.example.springweb.dto.UserDto;
import com.example.springweb.dto.UserStudent;
import com.example.springweb.model.User;
import com.example.springweb.response.Response;
import com.example.springweb.service.StudentService;
import com.example.springweb.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/register")
	public ResponseEntity<String>  addUser(@RequestBody UserStudent  user) {
		
		UserDto userdto=new UserDto();
		userdto.setUserName(user.getUserName());
		userdto.setPassword(user.getPassword());
		
		StudentDto studentdto=new StudentDto();
		studentdto.setName(user.getName());
		studentdto.setEmail(user.getEmail());
		studentdto.setDob(user.getDob());
		
		studentService.addStudent(studentdto);
		userService.addUser(userdto);
		return ResponseEntity.status(201).body("User added Successfully");
		
	}
	@GetMapping("/getUsers")
	public List<User> getUsers(){
		return userService.getusers();
	}
	
	@PostMapping("/login")
	public ResponseEntity<Response<String>> Login(@RequestBody User user) {
		
		try {
			Response<String> response=new Response<>();
			String token=userService.verify(user);
			response.setData(token);
			response.setHttpstatus(HttpStatus.OK);
			response.setSuccess(true);
			return ResponseEntity.status(200).body(response);
		}
		catch(Exception e){
			Response<String> response=new Response<>();
			response.setData(e.getMessage());
			response.setHttpstatus(HttpStatus.UNAUTHORIZED);
			response.setSuccess(false);
			return ResponseEntity.status(401).body(response);
		}
	}

}
