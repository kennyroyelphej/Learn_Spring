package com.elcorp.pocsecurity.controller;

import com.elcorp.pocsecurity.entity.Student;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("manage/student")
public class StudentManagementController {

    private static final List<Student> STUDENT_LIST = Arrays.asList(
            new Student(1,"Sirena Johnston"),
            new Student(2,"Stuart Frazier"),
            new Student(3,"Virgil Cooper"),
            new Student(4,"Georgette Harmon")
    );

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MANAGER')")
    public List<Student> getStudents(){
        return STUDENT_LIST;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('student:write')")
    public Student createStudent(@RequestBody Student student){
        System.out.println("create: " + student.toString());
        return student;
    }

    @PutMapping(path = "{id}")
    @PreAuthorize("hasAuthority('student:write')")
    public Student updateStudent(@PathVariable("id") Integer id, @RequestBody Student student){
        student.setStudentId(id);
        System.out.println("update: " + student);
        return student;
    }

    @DeleteMapping(path = "{id}")
    @PreAuthorize("hasAuthority('student:write')")
    public String deleteStudent(@PathVariable("id") Integer id){
        System.out.println("removed id: " + id);
        return "remove student "+id;
    }

}
