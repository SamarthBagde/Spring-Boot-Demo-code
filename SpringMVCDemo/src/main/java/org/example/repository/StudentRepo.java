package org.example.repository;

import org.example.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentRepo {

    private Map<Long, Student> studentDb;

    public StudentRepo() {
        studentDb = new HashMap<>();
    }

    public Student findById(Long id){
        return studentDb.get(id);
    }

    public List<Student> findAll(){
        return new ArrayList<>(studentDb.values());
    }

    public Student save(Student student){
        studentDb.put(student.getId(), student);
        return student;
    }

}
