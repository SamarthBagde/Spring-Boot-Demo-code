package com.example.JPARelationShipDemo.controller;


import com.example.JPARelationShipDemo.model.Department;
import com.example.JPARelationShipDemo.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {

    DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService){
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<String> createDepartment(@RequestBody Department department){

        departmentService.createDepartment(department);
        return ResponseEntity.ok("Done");
    }
}
