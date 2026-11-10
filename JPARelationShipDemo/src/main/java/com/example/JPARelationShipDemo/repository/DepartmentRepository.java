package com.example.JPARelationShipDemo.repository;


import com.example.JPARelationShipDemo.model.Department;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Department department){
        entityManager.persist(department);
    }


    public Department getById(Long id){
        return entityManager.find(Department.class, id);
    }
}
