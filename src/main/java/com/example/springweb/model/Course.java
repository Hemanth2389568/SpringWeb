 package com.example.springweb.model;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString(exclude = "enrollment")
public class Course {


   
    @Id
    private String course_id;

    private String name;

    private String description;
    
    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Enrollment> enrollment;

    // Getters and Setters
}

