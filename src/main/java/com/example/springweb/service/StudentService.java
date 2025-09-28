package com.example.springweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

import com.example.springweb.dto.StudentDto;
import com.example.springweb.model.Student;
import com.example.springweb.model.User;
import com.example.springweb.repository.StudentDao;

import jakarta.transaction.Transactional;

@Service
public class StudentService {
	
	@Autowired
	private StudentDao dao;
	
	
	public void addStudent(StudentDto s) {
		Student student=new Student();
		student.setName(s.getName());
		student.setEmail(s.getEmail());
		student.setDob(s.getDob());
		dao.save(student);
	}

	public List<Student>  findall() {
		
		return dao.findAll();
		// TODO Auto-generated method stub
		
	}

	public void updateStudent(int id,Student s) {
		// TODO Auto-generated method stub
		Student oldStudent=dao.findById(id).orElseThrow(()->new RuntimeException("Student not found with Id"+id));
		
		oldStudent.setName(s.getName());
		oldStudent.setDob(s.getDob());
		oldStudent.setEmail(s.getEmail());
		oldStudent.setId(id);
		dao.save(oldStudent);
	}

	@Transactional 
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		Student s=dao.findById(id).orElseThrow(()->new RuntimeException("Student not found eith id:"+id));
		dao.delete(s);
	}
}
