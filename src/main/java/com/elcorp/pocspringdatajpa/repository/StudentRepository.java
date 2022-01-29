package com.elcorp.pocspringdatajpa.repository;

import com.elcorp.pocspringdatajpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

//    https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods

    public List<Student> findByName(String name);
    public List<Student> findByNameContaining(String name);
    public List<Student> findByNameNotNull();
    public List<Student> findByGuardianName(String guardianName);
    public List<Student> findByGuardianNameAndName(String guardianName,String name);

//    JPQL
    @Query("select s from Student s where s.email = ?1")
    public Student getStudentByEmailAddress(String email);

//    Native Query
    @Query(
            value = "select * from student_info s where s.email_address = ?1",
            nativeQuery = true
    )
    public Student getStudentByEmailAddressNative(String email);

//    Named Parameter
    @Query(
            value = "select * from student_info s where s.email_address = :email",
            nativeQuery = true
    )
    public Student getStudentByEmailAddressNativeNamedParam(@Param("email") String email);

//    Modifying and transactional
    @Modifying
    @Transactional
    @Query(
            value = "update student_info set name = :name where email_address = :email",
            nativeQuery = true
    )
    public void updateStudentNameByEmail(@Param("name") String name, @Param("email") String email);

}
