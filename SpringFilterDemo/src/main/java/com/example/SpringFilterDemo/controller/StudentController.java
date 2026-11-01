package com.example.SpringFilterDemo.controller;

import com.example.SpringFilterDemo.dto.StudentDto;
import com.example.SpringFilterDemo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<String> createStudent(@RequestBody StudentDto student){
        studentService.createStudent(student);
        return ResponseEntity.ok("Student Created");
    }
}
