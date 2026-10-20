package org.example.service;

import org.example.entity.Student;
import org.example.repository.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private StudentRepo studentRepo;

    public StudentService(StudentRepo studentRepo){
        this.studentRepo = studentRepo;
    }

    public Student createStudent(Student student){
        return studentRepo.save(student);
    }

    public Student getStudent(long id){
        return studentRepo.findById(id);
    }

    public List<Student> getAllStudent(){
        return studentRepo.findAll();
    }
}
