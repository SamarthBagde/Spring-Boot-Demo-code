package com.example.AOPDemo.service;

import com.example.AOPDemo.annotation.TrackExecutionTime;
import com.example.AOPDemo.dto.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @TrackExecutionTime(warnAfter = 1500, operation = "Create Student")
    public String createStudent(Student student) {
        try {
            Thread.sleep(2000);
        }
        catch(Exception e) {}
        System.out.println("Student saved");
//        throw new RuntimeException("Some error happened"); // this will avoid running [logAfterReturningMethod] | this will run the [logAfterThrowingMethod]
        return "Student saved";
    }

    @TrackExecutionTime
    public String dummyMethod(String s) {
        System.out.println("dummyMethod called");
        return s;
    }

}
