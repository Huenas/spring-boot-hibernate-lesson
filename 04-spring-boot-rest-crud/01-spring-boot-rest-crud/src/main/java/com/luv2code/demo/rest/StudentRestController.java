package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController{


    private List<Student> theStudents;

    //define @PostConstruct to land the student data ... only once
    @PostConstruct
    public void loadData() {
        theStudents = new ArrayList<>();

        theStudents.add(new Student("mario", "rossi"));
        theStudents.add(new Student("Juju", "lulu"));
        theStudents.add(new Student("name", "test"));

    }
    // define an endpoint for "/students" -> return a list of students

    @GetMapping("/students")
    public List<Student> getStudents(){
        return theStudents;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        //just index into the list
        //check the studentId again list size
        if ((studentId > theStudents.size()) || (studentId < 0)) {
            throw new StudentNotFoundException("student not found - " + studentId);

        }


        return theStudents.get(studentId);
    }


}
