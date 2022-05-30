package com.finalproject.mycanvas.courses.controller;


import com.finalproject.mycanvas.announcement.model.Announcement;
import com.finalproject.mycanvas.assignments.model.Assignment;
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

    @GetMapping("/courses/{id}/announcements")
    public ResponseEntity getAnnouncementsById(@PathVariable Long id) {

        List<Announcement> announcements = courseService.getAnnouncementsByCourseId(id);
        return ResponseEntity.ok(announcements);
    }


    @GetMapping("/courses/{id}/assignments")
    public ResponseEntity getAssignmentsById(@PathVariable Long id) {

        List<Assignment> assignments = courseService.getAssignmentsByCourseId(id);
        return ResponseEntity.ok(assignments);
    }
    @PostMapping("/courses/{id}/assignments")
    public ResponseEntity addAssignmentToCourse(@PathVariable Long id,
                                                @RequestBody Assignment assignment) {
        ResponseEntity responseEntity = courseService.addAssignmentToCourse(id, assignment);
        return ResponseEntity.ok(201);
    }

    @PutMapping("/courses/{id}")
    public ResponseEntity updateCourse(@PathVariable Long id,
                                       @RequestBody Course course) {
        course = courseService.updateCourse(id, course);
        return ResponseEntity.ok(course);
    }
}
