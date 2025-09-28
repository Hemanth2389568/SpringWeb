package com.example.springweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springweb.model.Student;


@Repository
public interface StudentDao extends JpaRepository<Student, Integer> {

	
}
