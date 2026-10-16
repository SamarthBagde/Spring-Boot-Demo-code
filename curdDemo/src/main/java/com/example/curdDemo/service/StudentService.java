package com.example.curdDemo.service;

import com.example.curdDemo.entity.Student;
import com.example.curdDemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

//    According to hard delete logic
//    public Student createStudent(Student student){
//        Student studentResp = studentRepository.save(student);
//        return studentResp;
//    }
//
//    public Student getStudent(Long id){
//        Optional<Student> studentResp = studentRepository.findById(id);
//
//        return studentResp.orElse(null);
//    }
//
//    public List<Student> getAllStudent(){
//        List<Student> studentList = studentRepository.findAll();
//
//        return studentList;
//    }
//
//    public Student updateStudent(Long id, Student studentReq){
//        Optional<Student> existingStu = studentRepository.findById(id);
//
//        if(existingStu.isEmpty()){
//            return null;
//        }
//
//        Student studentToSave = existingStu.get();
//
//        studentToSave.setName(studentReq.getName());
//        studentToSave.setAge(studentReq.getAge());
//        studentToSave.setEmail(studentReq.getEmail());
//        studentToSave.setRollNo(studentReq.getRollNo());
//        studentToSave.setSubject(studentReq.getSubject());
//
//        return studentRepository.save(studentToSave);
//    }
//
//    public Boolean deleteStudent(Long id){
//        Boolean isFound = studentRepository.existsById(id);
//
//        if(!isFound) return false;
//
//        studentRepository.deleteById(id);
//
//        return true;
//    }


    // According to soft delete logic

    public Student createStudent(Student student){
        student.setDeleted(false);
        Student studentResp = studentRepository.save(student);
        return studentResp;
    }

    public Student getStudent(Long id){

        Optional<Student> studentResp = studentRepository.findByIdAndIsDeletedFalse(id);

        return studentResp.orElse(null);
    }

    public List<Student> getAllStudent(){
        List<Student> studentList = studentRepository.findByIsDeletedFalse();

        return studentList;
    }

    public Student updateStudent(Long id, Student studentReq){
        Optional<Student> existingStu = studentRepository.findByIdAndIsDeletedFalse(id);

        if(existingStu.isEmpty()){
            return null;
        }

        Student studentToSave = existingStu.get();

        studentToSave.setName(studentReq.getName());
        studentToSave.setAge(studentReq.getAge());
        studentToSave.setEmail(studentReq.getEmail());
        studentToSave.setRollNo(studentReq.getRollNo());
        studentToSave.setSubject(studentReq.getSubject());

        studentToSave.setDeleted(false);
        return studentRepository.save(studentToSave);
    }

    public Boolean deleteStudent(Long id){
        Optional<Student> existingStu = studentRepository.findByIdAndIsDeletedFalse(id);

        if(existingStu.isEmpty()) return false;

        Student studenToSave = existingStu.get();

        studenToSave.setDeleted((true));

        studentRepository.save(studenToSave);

        return true;
    }
}
