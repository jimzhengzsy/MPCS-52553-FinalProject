package com.finalproject.mycanvas.courses.controller;


import com.finalproject.mycanvas.courses.model.Course;
import com.finalproject.mycanvas.courses.services.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/courses/{id}")
    public ResponseEntity getCourseById(@PathVariable Long id) {
        Course course = courseService.getCourseById(id);
        return ResponseEntity.ok(course);
    }

    @PutMapping("/courses/{id}")
    public ResponseEntity updateCourse(@PathVariable Long id,
                                       @RequestBody Course course) {
        course = courseService.updateCourse(id, course);
        return ResponseEntity.ok(course);
    }
}
