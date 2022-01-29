package com.elcorp.pocspringdatajpa.repository;

import com.elcorp.pocspringdatajpa.entity.Guardian;
import com.elcorp.pocspringdatajpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Guardian guardian = Guardian.builder()
                .name("Ged Burgess")
                .email("burgess@gmail.com")
                .build();
        Student student = Student.builder()
                .name("Jeremy Freeman")
                .email("freeman@elcorp.com")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void getAllStudents(){
        List<Student> students = studentRepository.findAll();
        System.out.println("Student List: "+ students);
    }

    @Test
    public void getStudentByName(){
        List<Student> students = studentRepository.findByName("Jeremy Freeman");
        System.out.println("Student List By Name: "+ students);
    }

    @Test
    public void getStudentByNameContains(){
        List<Student> students = studentRepository.findByNameContaining("freeman");
        System.out.println("Student List By Name Contains: "+ students);
    }

    @Test
    public void getStudentByGuardianName(){
        List<Student> students = studentRepository.findByGuardianName("Ged Burgess");
        System.out.println("Student List By Guardian Name: "+ students);
    }

    @Test
    public void getStudentByEmail(){
        Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("freeman@elcorp.com");
        System.out.println("Student By Email: "+ student);
    }

    @Test
    public void updateStudentNameByEmail(){
        studentRepository.updateStudentNameByEmail("Jeremy Herold Freeman","freeman@elcorp.com");
    }

}