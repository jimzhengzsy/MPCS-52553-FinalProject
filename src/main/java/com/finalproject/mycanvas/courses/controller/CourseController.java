package com.finalproject.mycanvas.courses.controller;


import com.finalproject.mycanvas.courses.model.Course;
import com.finalproject.mycanvas.courses.services.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/courses")
    public ResponseEntity createCourse(@RequestBody Course course) throws Exception {
        return courseService.createCourse(course);
    }
}
