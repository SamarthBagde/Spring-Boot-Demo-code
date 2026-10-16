package com.example.curdDemo.controller;

import com.example.curdDemo.entity.Student;
import com.example.curdDemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

// These are all are according to hard delete student logic
//    @PostMapping("/") // create
//    public ResponseEntity<Student> createStudent(@RequestBody Student student){
//     Student createdStudent = studentService.createStudent(student);
//     return ResponseEntity
//             .status(201)
//             .body(createdStudent);
//    }
//
//    @GetMapping("/{id}") // get
//    public ResponseEntity<Student> getStudent(@PathVariable Long id){
//        Student res = studentService.getStudent(id);
//
//        if(res == null){
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity
//                .status(200)
//                .body(res);
//    }
//
//    @GetMapping("/") // get all
//    public ResponseEntity<List<Student>> getAllStudents(){
//        List<Student> res = studentService.getAllStudent();
//
//        if(res == null){
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity
//                .status(200)
//                .body(res);
//    }
//
//    @PutMapping("/{id}") // edit
//    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student studentReq){
//        Student res = studentService.updateStudent(id, studentReq);
//
//        if(res == null){
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity
//                .status(200)
//                .body(res);
//    }
//
//    @DeleteMapping("/{id}") // delete
//    public ResponseEntity<String> updateStudent(@PathVariable Long id){
//        Boolean isDeleted = studentService.deleteStudent(id);
//
//        if(!isDeleted){
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity
//                .status(200)
//                .body("Record deleted");
//    }
//

    //According to soft delete logic

    @PostMapping("/") // create
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student createdStudent = studentService.createStudent(student);
        return ResponseEntity
                .status(201)
                .body(createdStudent);
    }

    @GetMapping("/{id}") // get
    public ResponseEntity<Student> getStudent(@PathVariable Long id){
        Student res = studentService.getStudent(id);

        if(res == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity
                .status(200)
                .body(res);
    }

    @GetMapping("/") // get all
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> res = studentService.getAllStudent();

        if(res == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity
                .status(200)
                .body(res);
    }

    @PutMapping("/{id}") // edit
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student studentReq){
        Student res = studentService.updateStudent(id, studentReq);

        if(res == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity
                .status(200)
                .body(res);
    }

    @PatchMapping("/{id}") // soft delete
    public ResponseEntity<String> updateStudent(@PathVariable Long id){
        Boolean isDeleted = studentService.deleteStudent(id);

        if(!isDeleted){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity
                .status(200)
                .body("Record deleted");
    }
}
