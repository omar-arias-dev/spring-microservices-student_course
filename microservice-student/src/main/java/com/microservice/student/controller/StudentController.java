package com.microservice.student.controller;

import com.microservice.student.entity.Student;
import com.microservice.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStudent(@RequestBody Student student) {
        studentService.save(student);
    }

    @GetMapping
    public ResponseEntity<?> findAllStudents() {
        return ResponseEntity.ok(studentService.findAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") long id) {
        return new ResponseEntity<>(studentService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/course/{id}")
    public ResponseEntity<?> findByCourseId(@PathVariable("id") long courseId) {
        return ResponseEntity.ok(studentService.findStudentsByCourseId(courseId));
    }
}
