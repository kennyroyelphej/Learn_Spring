package com.elcorp.pocsecurity.controller;

import com.elcorp.pocsecurity.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    private static final List<Student> STUDENT_LIST = Arrays.asList(
            new Student(1,"Sirena Johnston"),
            new Student(2,"Stuart Frazier"),
            new Student(3,"Virgil Cooper"),
            new Student(4,"Georgette Harmon")
    );

    @GetMapping("{id}")
    public Student getStudentById(@PathVariable("id") Integer id){
        return STUDENT_LIST.stream()
                .filter(student -> id.equals(student.getStudentId()))
                .findFirst()
                .orElseThrow(()->new IllegalStateException("Student not found with id: " + id));
    }

}
