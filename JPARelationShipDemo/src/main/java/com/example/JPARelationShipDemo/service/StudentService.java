package com.example.JPARelationShipDemo.service;

import com.example.JPARelationShipDemo.model.Department;
import com.example.JPARelationShipDemo.model.Student;
import com.example.JPARelationShipDemo.repository.DepartmentRepository;
import com.example.JPARelationShipDemo.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    StudentRepository studentRepository;
    DepartmentRepository departmentRepository;

    public StudentService(StudentRepository studentRepository,
                          DepartmentRepository departmentRepository){
        this.studentRepository = studentRepository;
        this.departmentRepository = departmentRepository;
    }

    @Transactional
    public void createStudent(Student student, Long deptId){
        Department department = departmentRepository.getById(deptId);

        student.setDepartment(department);
        studentRepository.save(student);
    }


}
