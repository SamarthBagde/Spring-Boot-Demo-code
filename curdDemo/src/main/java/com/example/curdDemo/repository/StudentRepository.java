package com.example.curdDemo.repository;

import com.example.curdDemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // this will automatically generate query to get only non deleted user
    Optional<Student> findByIdAndIsDeletedFalse(long id);


//    @Query(
//            value = "SELECT * FROM student WHERE is_deleted = false",
//            nativeQuery = true
//    )
//    List<Student> findActiveStudents();

    // findBy + filedName + condition
    List<Student> findByIsDeletedFalse();
}
