package com.example.SpringFilterDemo.service;

import com.example.SpringFilterDemo.dto.StudentDto;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public void createStudent(StudentDto student){
        System.out.println("Student Created");
        System.out.println(student.getName());
        System.out.println(student.getEmail());
    }
}
