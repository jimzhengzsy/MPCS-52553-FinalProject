package com.finalproject.mycanvas.users.services;

import com.finalproject.mycanvas.announcement.model.Announcement;
import com.finalproject.mycanvas.assignments.model.Assignment;
import com.finalproject.mycanvas.courses.model.Course;
import com.finalproject.mycanvas.users.entity.CheckAnswersRequestbody;
import com.finalproject.mycanvas.users.entity.NamePair;
import com.finalproject.mycanvas.users.model.User;
import com.finalproject.mycanvas.users.model.UserInfo;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    ResponseEntity createUser(User user) throws Exception;
    List<User> getAllUsers();

    User getUserById(Long id);

    User getUserByEmail(String email);

    List<User> getUserByFirstName(String firstName);

    List<User> getUserByLastName(String lastName);

    List<User> getTeachers();

    NamePair getNamePairByEmail(String email);
    User updateUser(Long id, User user);

    ResponseEntity LoginUser(String email, String password);

    ResponseEntity checkEmail(String email);

    ResponseEntity checkLoginAnswers(String[] answers, Long id);

    UserInfo getInfoById(Long id);

    List<Course> getCourses(Long userId);

    List<Object> getStudentAssignmentData(Long userId, Long courseId);

    ResponseEntity addCourse(Long userId, Course course);
    List<Assignment> getAssignment(Long userId);

    ResponseEntity addAssignment(Long userId, Assignment assignment);

    List<Announcement> getAnnouncement(Long userId);

    ResponseEntity addAnnouncement(Long userId, Announcement announcement);

//    Course addUserWithCourse(Long userId, Long courseId);
}
