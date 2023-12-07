package com.microservice.course.controller;

import com.microservice.course.entity.Course;
import com.microservice.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStudent(@RequestBody Course course) {
        courseService.save(course);
    }

    @GetMapping
    public ResponseEntity<?> findAllStudents() {
        return ResponseEntity.ok(courseService.findAllCourses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") long id) {
        return new ResponseEntity<>(courseService.findByCourseId(id), HttpStatus.OK);
    }

    @GetMapping("/{id}/students")
    public ResponseEntity<?> findStudentsByCourseId(@PathVariable long id) {
        return ResponseEntity.ok(courseService.findStudentsByCourseId(id));
    }
}
