package com.example.springweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springweb.model.Course;
import com.example.springweb.model.Enrollment;
import com.example.springweb.repository.EnrollmentDao;

@Service
public class EnrollmentService {
	
	@Autowired
	private EnrollmentDao dao;
	
	public void enrrollCourse(Enrollment e) {
		
		Enrollment e1=new Enrollment();
		e1.setCourse(e.getCourse());
		e1.setStudent(e.getStudent());
		e1.setId(generateEnrollmentId(e.getCourse()));
		e1.setDate(e.getDate());
		
		dao.save(e1);
	}
	
	public List<Enrollment> findallEnrollments() {
		return dao.findAll();
	}

	public void updateEnrollment(int id,Enrollment e) {
		// TODO Auto-generated method stu
		
	}
	
	public String generateEnrollmentId(Course course) {
		
		int count=dao.countByCourse(course);
		return course.getCourse_id()+String.valueOf(count);
		
	}

}
