package com.finalproject.mycanvas.users.controller;

import com.finalproject.mycanvas.announcement.model.Announcement;
import com.finalproject.mycanvas.assignments.model.Assignment;
import com.finalproject.mycanvas.courses.model.Course;
import com.finalproject.mycanvas.users.entity.CheckAnswersRequestbody;
import com.finalproject.mycanvas.users.entity.LoginData;
import com.finalproject.mycanvas.users.entity.NamePair;
import com.finalproject.mycanvas.users.entity.UserEntity;
import com.finalproject.mycanvas.users.model.User;
import com.finalproject.mycanvas.users.model.UserInfo;
import com.finalproject.mycanvas.users.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000")
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

    @GetMapping("/users/email/{email}")
    public ResponseEntity getUserByEmail(@PathVariable String email) {
        User user = null;
        user = userService.getUserByEmail(email);
        if (user == null) {
            return ResponseEntity.status(404).body("Email Not Found");
        }
        return ResponseEntity.ok(user);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id,
                                           @RequestBody User user) {
        user = userService.updateUser(id, user);
        return ResponseEntity.ok(user);

    }

    @PostMapping("/login")
    public ResponseEntity loginUser(@RequestBody LoginData loginData) {
        ResponseEntity responseEntity = userService.LoginUser(loginData.getEmail(),loginData.getPassword());

        return responseEntity;
    }

    @PostMapping("/checkEmail/{email}")
    public ResponseEntity checkEmail(@PathVariable String email) {
        ResponseEntity responseEntity = userService.checkEmail(email);

        return responseEntity;
    }

    @PostMapping("/checkAnswers")
    public ResponseEntity checkAnswers(@RequestBody CheckAnswersRequestbody checkAnswersRequestbody) {
        Long id = checkAnswersRequestbody.getId();
        String[] answers = new String[3];
        answers[0] = checkAnswersRequestbody.getAnswers();
        answers[1] = checkAnswersRequestbody.getAnswer2();
        answers[2] = checkAnswersRequestbody.getAnswer3();

        ResponseEntity responseEntity = userService.checkLoginAnswers(answers, id);

        return responseEntity;
    }

    @GetMapping("/users-info/{id}")
    public ResponseEntity<UserInfo> getInfoById(@PathVariable Long id) {
        UserInfo userInfo = null;
        userInfo = userService.getInfoById(id);

        return ResponseEntity.ok(userInfo);
    }

    @GetMapping("/users/{id}/courses")
    public ResponseEntity getCourses(@PathVariable Long id) {
        List<Course> courses = userService.getCourses(id);
        if (courses.size() == 0) {
            return ResponseEntity.status(404).body("No courses");
        }

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

    @GetMapping("/users/{email}/namepair")
    public ResponseEntity getNamePair(@PathVariable String email) {
        NamePair namePair = userService.getNamePairByEmail(email);

        return ResponseEntity.ok(namePair);
    }

    @GetMapping("/users/firstname/{firstName}")
    public ResponseEntity getUserByFirstName(@PathVariable String firstName) {
        List<User> users = userService.getUserByFirstName(firstName);

        return ResponseEntity.ok(users);
    }

    @GetMapping("/users/lastName/{lastName}")
    public ResponseEntity getUserByLastName(@PathVariable String lastName) {
        List<User> users = userService.getUserByLastName(lastName);

        return ResponseEntity.ok(users);
    }


    @GetMapping("/users/teachers")
    public ResponseEntity getTeachers() {
        List<User> users = userService.getTeachers();

        return ResponseEntity.ok(users);
    }

    @GetMapping(("/users/{userId}/courses/{coursesId}"))
    public ResponseEntity getStudentAssignmentData(@PathVariable Long userId,
                                                   @PathVariable Long coursesId){
        List<Object> data = userService.getStudentAssignmentData(userId, coursesId);
        return ResponseEntity.ok(data);
    }

    @PostMapping("/users/{id}/courses")
    public ResponseEntity addCourse(@PathVariable Long id,
                                    @RequestBody Course course) {
        ResponseEntity responseEntity = userService.addCourse(id, course);

        return ResponseEntity.ok(201);
    }

    @PostMapping("/users/{id}/assignments")
    public ResponseEntity addAssignment(@PathVariable Long id,
                                    @RequestBody Assignment assignment) {
        ResponseEntity responseEntity = userService.addAssignment(id, assignment);

        return ResponseEntity.ok(201);
    }

    @PostMapping("/users/{id}/announcements")
    public ResponseEntity addAnnouncement(@PathVariable Long id,
                                        @RequestBody Announcement announcement) {
        ResponseEntity responseEntity = userService.addAnnouncement(id, announcement);

        return ResponseEntity.ok(201);
    }

}
