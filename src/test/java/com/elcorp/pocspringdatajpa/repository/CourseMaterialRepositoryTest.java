package com.elcorp.pocspringdatajpa.repository;

import com.elcorp.pocspringdatajpa.entity.Course;
import com.elcorp.pocspringdatajpa.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void SaveNewCourse(){
        Course course = Course.builder()
                .title("Introduction to Java")
                .credits(6)
                .build();
        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.java.com")
                .course(course)
                .build();
        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void getAllCourseMaterials(){
        List<CourseMaterial> courseMaterials = courseMaterialRepository.findAll();
        System.out.println("Course Material List: " + courseMaterials);
    }

}