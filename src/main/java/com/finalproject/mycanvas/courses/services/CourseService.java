package com.finalproject.mycanvas.courses.services;

import com.finalproject.mycanvas.courses.model.Course;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CourseService {

    ResponseEntity createCourse(Course course) throws Exception;

    List<Course> getAllCourses();

    Course getCourseById(Long id);

    Course updateCourse(Long id, Course course);

}
