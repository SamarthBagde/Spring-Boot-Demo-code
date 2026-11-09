package com.example.AOPDemo.controller;

import com.example.AOPDemo.dto.Student;
import com.example.AOPDemo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<String> createStudent() {

        Student stu = new Student("Sam", "Spring");
        String s = studentService.createStudent(stu);
        return ResponseEntity.ok(s);
    }

    @GetMapping
    public ResponseEntity<String> dummyMethod() {
        String s = "ABCD ";
        return ResponseEntity.ok(studentService.dummyMethod(s));
    }
}
