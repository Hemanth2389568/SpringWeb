package com.example.springweb.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class StudentDto {

	@Id
    private int id;

    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    private String dob;
}
