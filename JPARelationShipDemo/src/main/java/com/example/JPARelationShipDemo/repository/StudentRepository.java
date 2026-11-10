package com.example.JPARelationShipDemo.repository;

import com.example.JPARelationShipDemo.model.Department;
import com.example.JPARelationShipDemo.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Student student){
        entityManager.persist(student);
    }
}
