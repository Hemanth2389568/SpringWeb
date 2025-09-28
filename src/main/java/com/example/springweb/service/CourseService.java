package com.example.springweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springweb.model.Course;
import com.example.springweb.repository.CourseDao;

@Service
public class CourseService {
	
	@Autowired
	private CourseDao dao;
	
	public void addCourse(Course c) {
		
		Course c1=new Course();
		c1.setCourse_id(c.getCourse_id());
		c1.setDescription(c.getDescription());
		c1.setName(c.getName());
		
		dao.save(c1);
	}
	
	
	public List<Course> findall() {
		return dao.findAll();
	}


	public void updateCourse(String id,Course c) {
		// TODO Auto-generated method stub
		Course oldCourse=dao.findById(id).orElseThrow(()->new RuntimeException("Course Not found with the Id:"+id));
		oldCourse.setCourse_id(id);
		oldCourse.setName(c.getName());
		oldCourse.setDescription(c.getDescription());
		dao.save(oldCourse);
		
		
	}

}
