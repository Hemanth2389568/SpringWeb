package com.example.springweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springweb.model.Course;
import com.example.springweb.model.Enrollment;

@Repository
public interface EnrollmentDao extends JpaRepository<Enrollment, String> {
	
	int countByCourse(Course course);
	

	//Query("SELECT e FROM Employee e WHERE e.salary > :minSalary")
	//List<Employee> findEmployeesWithHighSalary(@Param("minSalary") double minSalary);


}
