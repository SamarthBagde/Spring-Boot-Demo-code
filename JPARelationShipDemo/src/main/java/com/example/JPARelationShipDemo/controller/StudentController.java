package com.example.JPARelationShipDemo.controller;

import com.example.JPARelationShipDemo.model.Student;
import com.example.JPARelationShipDemo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<String> createStudent(@RequestBody Student student, @RequestParam Long deptid){
        studentService.createStudent(student, deptid);

        return ResponseEntity.ok("Done");
    }
}
