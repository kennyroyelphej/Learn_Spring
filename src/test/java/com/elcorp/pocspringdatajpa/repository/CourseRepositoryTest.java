package com.elcorp.pocspringdatajpa.repository;

import com.elcorp.pocspringdatajpa.entity.Course;
import com.elcorp.pocspringdatajpa.entity.Guardian;
import com.elcorp.pocspringdatajpa.entity.Student;
import com.elcorp.pocspringdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void getAllCourses(){
        List<Course> courses = courseRepository.findAll();
        System.out.println("Course List: " + courses);
    }

    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher = Teacher.builder()
                .name("Joseph Webb")
                .build();
        Course course = Course.builder()
                .title("Python")
                .credits(6)
                .teacher(teacher)
                .build();
        courseRepository.save(course);
    }

    @Test
    public void getCoursePaged(){
        Pageable newPage = PageRequest.of(0,2);
        List<Course> courses = courseRepository.findAll(newPage).getContent();
        long totalElements = courseRepository.findAll(newPage).getTotalElements();
        long totalPages = courseRepository.findAll(newPage).getTotalPages();
        System.out.println("Elements: "+totalElements);
        System.out.println("Pages: "+totalPages);
        System.out.println("Courses: "+courses);
    }

    @Test
    public void getCoursePagedSorted(){
        Pageable newPage = PageRequest.of(0,2, Sort.by("title").descending());
        List<Course> courses = courseRepository.findAll(newPage).getContent();
        long totalElements = courseRepository.findAll(newPage).getTotalElements();
        long totalPages = courseRepository.findAll(newPage).getTotalPages();
        System.out.println("Elements: "+totalElements);
        System.out.println("Pages: "+totalPages);
        System.out.println("Courses: "+courses);
    }

    @Test
    public void getCourseSearchPaged(){
        Pageable newPage = PageRequest.of(0,2);
        List<Course> courses = courseRepository.findByTitleContaining("JQ",newPage);
        System.out.println("courses = " + courses);
    }

    @Test
    public void saveCourseWithStudentAndTeacher(){
        Teacher teacher = Teacher.builder()
                .name("Skye Pascall")
                .build();
        Guardian guardian = Guardian.builder()
                .name("Holden")
                .email("holden@gmail.com")
                .build();
        Student student = Student.builder()
                .name("Tess Holden")
                .email("tess@elcorp.com")
                .guardian(guardian)
                .build();
        Course course = Course.builder()
                .title("AI")
                .credits(8)
                .teacher(teacher)
                .build();
        course.addStudents(student);
        courseRepository.save(course);
    }

}