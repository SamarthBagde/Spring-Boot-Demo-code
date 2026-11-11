package com.example.SpringDataJPADemo.service;

import com.example.SpringDataJPADemo.entity.Student;
import com.example.SpringDataJPADemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public void createStudent(Student student){
        studentRepository.save(student);
    }

    public  Student getStudentById(Long id){
        Optional<Student> student =  studentRepository.findById(id);

        return student.get();
    }
}
