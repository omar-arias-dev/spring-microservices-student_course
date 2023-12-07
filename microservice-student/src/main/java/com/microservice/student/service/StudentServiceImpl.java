package com.microservice.student.service;

import com.microservice.student.entity.Student;
import com.microservice.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> findAllStudents() {
        return (List<Student>) studentRepository.findAll();
    }

    @Override
    public Student findById(long studentId) {
        return studentRepository.findById(studentId).orElseThrow();
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public List<Student> findStudentsByCourseId(long courseId) {
        return studentRepository.findAllByCourseId(courseId);
    }
}
