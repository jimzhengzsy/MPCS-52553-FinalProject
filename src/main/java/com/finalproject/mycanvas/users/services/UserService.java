package com.finalproject.mycanvas.users.services;

import com.finalproject.mycanvas.announcement.model.Announcement;
import com.finalproject.mycanvas.assignments.model.Assignment;
import com.finalproject.mycanvas.courses.model.Course;
import com.finalproject.mycanvas.users.model.User;
import com.finalproject.mycanvas.users.model.UserInfo;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    ResponseEntity createUser(User user) throws Exception;
    List<User> getAllUsers();

    User getUserById(Long id);

    User updateUser(Long id, User user);

    ResponseEntity LoginUser(String email, String password);

    UserInfo getInfoById(Long id);

    List<Course> getCourses(Long userId);

    List<Assignment> getAssignment(Long userId);

    List<Announcement> getAnnouncement(Long userId);

//    Course addUserWithCourse(Long userId, Long courseId);
}
