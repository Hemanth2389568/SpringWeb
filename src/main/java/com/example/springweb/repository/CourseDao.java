package com.example.springweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springweb.model.Course;

@Repository
public interface CourseDao extends JpaRepository<Course, String> {

}
