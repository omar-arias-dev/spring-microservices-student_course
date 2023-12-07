package com.microservice.course.service;

import com.microservice.course.entity.Course;
import com.microservice.course.http.response.StudentByCourseResponse;

import java.util.List;

public interface CourseService {

    List<Course> findAllCourses();

    Course findByCourseId(long courseId);

    void save(Course course);

    StudentByCourseResponse findStudentsByCourseId(long courseId);
}
