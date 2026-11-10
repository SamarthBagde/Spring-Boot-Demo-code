package com.example.JPARelationShipDemo.service;


import com.example.JPARelationShipDemo.model.Department;
import com.example.JPARelationShipDemo.repository.DepartmentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository){
        this.departmentRepository = departmentRepository;
    }

    @Transactional
    public void createDepartment(Department department){
        departmentRepository.save(department);
    }
}
