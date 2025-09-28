package com.example.springweb.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString(exclude = "enrollment")
@Table(name="student")
public class Student {

    @Id()
    private int id;

    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    private String dob;
    
    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Enrollment> enrollment;

    // Getters and Setters
    
}

