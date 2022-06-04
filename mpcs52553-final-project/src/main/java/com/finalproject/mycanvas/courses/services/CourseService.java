package com.finalproject.mycanvas.courses.services;

import com.finalproject.mycanvas.announcement.model.Announcement;
import com.finalproject.mycanvas.assignments.model.Assignment;
import com.finalproject.mycanvas.courses.model.Course;
import com.finalproject.mycanvas.users.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CourseService {

    ResponseEntity createCourse(Course course) throws Exception;

    List<Course> getAllCourses();

    Course getCourseById(Long id);

    Course updateCourse(Long id, Course course);

    ResponseEntity addUserToCourse(Long courseId, User user);

    ResponseEntity addAssignmentToCourse(Long courseId, Assignment assignment);

    ResponseEntity addAnnouncementToCourse(Long courseId, Announcement announcement);

    List<User> getUsers(Long id);

    List<Object> getCourseAssignmentData(Long id);

    List<Announcement> getAnnouncementsByCourseId(Long courseId);

    List<Assignment> getAssignmentsByCourseId(Long courseId);

}
