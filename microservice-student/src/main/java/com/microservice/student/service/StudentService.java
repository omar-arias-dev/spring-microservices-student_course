package com.microservice.student.service;

import com.microservice.student.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAllStudents();

    Student findById(long studentId);

    void save(Student student);

    List<Student> findStudentsByCourseId(long courseId);
}
