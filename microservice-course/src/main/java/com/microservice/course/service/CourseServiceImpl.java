package com.microservice.course.service;

import com.microservice.course.DTO.StudentDTO;
import com.microservice.course.client.StudentClient;
import com.microservice.course.entity.Course;
import com.microservice.course.http.response.StudentByCourseResponse;
import com.microservice.course.repository.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CoursesRepository coursesRepository;

    @Autowired
    private StudentClient studentClient;

    @Override
    public List<Course> findAllCourses() {
        return (List<Course>) coursesRepository.findAll();
    }

    @Override
    public Course findByCourseId(long courseId) {
        return coursesRepository.findById(courseId).orElseThrow();
    }

    @Override
    public void save(Course course) {
        coursesRepository.save(course);
    }

    @Override
    public StudentByCourseResponse findStudentsByCourseId(long courseId) {

        Course course = coursesRepository.findById(courseId).orElse(new Course());

        List<StudentDTO> studentDTOList = studentClient.findAllStudentsByCourse(course.getId());

        return StudentByCourseResponse.builder()
                .courseName(course.getName())
                .teacher(course.getTeacher())
                .studentDTOList(studentDTOList)
                .build();
    }
}
