package com.finalproject.mycanvas.users.controller;

import com.finalproject.mycanvas.announcement.model.Announcement;
import com.finalproject.mycanvas.assignments.model.Assignment;
import com.finalproject.mycanvas.courses.model.Course;
import com.finalproject.mycanvas.users.model.User;
import com.finalproject.mycanvas.users.model.UserInfo;
import com.finalproject.mycanvas.users.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/users")
    public ResponseEntity createUser(@RequestBody User user) throws Exception {
        return userService.createUser(user);
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = null;
        user = userService.getUserById(id);

        return ResponseEntity.ok(user);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id,
                                           @RequestBody User user) {
        user = userService.updateUser(id, user);
        return ResponseEntity.ok(user);

    }

    @PostMapping("/login")
    public ResponseEntity loginUser(@RequestBody String email, String password) {
        ResponseEntity responseEntity = userService.LoginUser(email, password);

        return responseEntity;
    }

    @GetMapping("/users-info/{id}")
    public ResponseEntity<UserInfo> getInfoById(@PathVariable Long id) {
        UserInfo userInfo = null;
        userInfo = userService.getInfoById(id);

        return ResponseEntity.ok(userInfo);
    }

    @GetMapping("/users/{id}/courses")
    public ResponseEntity<List<Course>> getCourses(@PathVariable Long id) {
        List<Course> courses = userService.getCourses(id);

        return ResponseEntity.ok(courses);
    }

    @GetMapping("/users/{id}/assignments")
    public ResponseEntity<List<Assignment>> getAssignment(@PathVariable Long id) {
        List<Assignment> assignments = userService.getAssignment(id);

        return ResponseEntity.ok(assignments);
    }
    @GetMapping("/users/{id}/announcements")
    public ResponseEntity<List<Announcement>> getAnnouncement(@PathVariable Long id) {
        List<Announcement> announcements = userService.getAnnouncement(id);

        return ResponseEntity.ok(announcements);
    }

    @PostMapping("/users/{id}/courses")
    public ResponseEntity addCourse(@PathVariable Long id,
                                    @RequestBody Course course) {
        ResponseEntity responseEntity = userService.addCourse(id, course);

        return ResponseEntity.ok(responseEntity);
    }

    @PostMapping("/users/{id}/assignments")
    public ResponseEntity addAssignment(@PathVariable Long id,
                                    @RequestBody Assignment assignment) {
        ResponseEntity responseEntity = userService.addAssignment(id, assignment);

        return ResponseEntity.ok(responseEntity);
    }

    @PostMapping("/users/{id}/announcements")
    public ResponseEntity addAnnouncement(@PathVariable Long id,
                                        @RequestBody Announcement announcement) {
        ResponseEntity responseEntity = userService.addAnnouncement(id, announcement);

        return ResponseEntity.ok(responseEntity);
    }

}
