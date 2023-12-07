package com.microservice.course.client;

import com.microservice.course.DTO.StudentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "ms-student", url = "localhost:8090/api/student")
public interface StudentClient {

    @GetMapping("/course/{id}")
    List<StudentDTO> findAllStudentsByCourse(@PathVariable long id);
}
