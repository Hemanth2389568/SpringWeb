package com.example.springweb.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class Enrollmentdto {
	
	private int id;
	private String student_id;
	private String course_id;
	private Date date;

}
