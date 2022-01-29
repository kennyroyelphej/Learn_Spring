package com.elcorp.pocspringdatajpa.repository;

import com.elcorp.pocspringdatajpa.entity.Course;
import com.elcorp.pocspringdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){
        Course courseJavaScript = Course.builder()
                .title("JavaScript")
                .credits(6)
                .build();
        Course courseJQuery = Course.builder()
                .title("JQuery")
                .credits(4)
                .build();
        Teacher teacher = Teacher.builder()
                .name("Patricia Lawson")
//                .courses(List.of(courseJavaScript,courseJQuery))
                .build();
        teacherRepository.save(teacher);
    }
}