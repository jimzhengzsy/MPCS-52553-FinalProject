package com.finalproject.mycanvas.users.services;

import com.finalproject.mycanvas.announcement.entity.AnnouncementEntity;
import com.finalproject.mycanvas.announcement.model.Announcement;
import com.finalproject.mycanvas.assignments.entity.AssignmentEntity;
import com.finalproject.mycanvas.assignments.model.Assignment;
import com.finalproject.mycanvas.courses.entity.CourseEntity;
import com.finalproject.mycanvas.courses.model.Course;
import com.finalproject.mycanvas.users.entity.UserEntity;
import com.finalproject.mycanvas.users.entity.UserInfoEntity;
import com.finalproject.mycanvas.users.model.User;
import com.finalproject.mycanvas.users.model.UserInfo;
import com.finalproject.mycanvas.users.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public ResponseEntity createUser(User user) throws Exception {
        if (user.getEmail() == "" || user.getFirstName() == "" || user.getLastName() == "") {
            return (ResponseEntity) ResponseEntity.status(400);
        }
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        userRepository.save(userEntity);

        return ResponseEntity.ok(user);
    }


    @Override
    public List<User> getAllUsers() {
        List<UserEntity> userEntities = userRepository.findAll();
        List<User> users = userEntities
                .stream()
                .map(user -> new User(user.getId(),
                        user.getFirstName(),
                        user.getLastName(),
                        user.getEmail(),
                        user.getRole(),
                        user.getStatus(),
                        user.getPassword(),
                        user.getLoginQuestion1(),
                        user.getLoginQuestion2(),
                        user.getLoginQuestion3()))
                .collect(Collectors.toList());
        return users;
    }

    @Override
    public User getUserById(Long id) {
        UserEntity userEntity = userRepository.findById(id).get();
        User user = new User();
        BeanUtils.copyProperties(userEntity,user);
        return user;
    }

    @Override
    public User updateUser(Long id, User user) {
        UserEntity userEntity = userRepository.findById(id).get();
        userEntity.setEmail(user.getEmail());
        userEntity.setStatus(user.getStatus());
        userEntity.setPassword(user.getPassword());
        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());
        userEntity.setRole(user.getRole());
        userEntity.setLoginQuestion1(user.getLoginQuestion1());
        userEntity.setLoginQuestion2(user.getLoginQuestion2());
        userEntity.setLoginQuestion3(user.getLoginQuestion3());

        userRepository.save(userEntity);

        return user;
    }

    @Override
    public ResponseEntity LoginUser(String email, String password) {
        UserEntity userEntity = userRepository.findByEmail(email);
        if (userEntity == null) {
            return (ResponseEntity) ResponseEntity.status(401);
        }

        String correctPassword = userEntity.getPassword();
        if (correctPassword.equals(password)) {
            return (ResponseEntity) ResponseEntity.status(200);
        }

        return (ResponseEntity) ResponseEntity.status(401);
    }

    @Override
    public UserInfo getInfoById(Long id) {
        User user = getUserById(id);
        UserInfo userInfo = UserInfo.builder()
                .id(user.getId())
                .email(user.getEmail())
                .lastName(user.getLastName())
                .firstName(user.getFirstName())
                .role(user.getRole())
                .build();


        return userInfo;
    }

    @Override
    public List<Course> getCourses(Long userId) {
        UserEntity userEntity = userRepository.findById(userId).get();
        List<CourseEntity> courseEntities = userEntity.getCourses();
        List<Course> courses = courseEntities
                .stream()
                .map(course -> new Course(course.getId(),
                        course.getName(),
                        course.getTeacherId()))
                .collect(Collectors.toList());

        return courses;

    }

    @Override
    public List<Assignment> getAssignment(Long userId) {
        UserEntity userEntity = userRepository.findById(userId).get();
        List<AssignmentEntity> assignmentEntities = userEntity.getAssignments();
        List<Assignment> assignments = assignmentEntities
                .stream()
                .map(assignment -> new Assignment(assignment.getId(),
                        assignment.getGrade(),
                        assignment.getTeacherId(),
                        assignment.getDue_date(),
                        assignment.getDescription()))
                .collect(Collectors.toList());
        return assignments;
    }

    @Override
    public List<Announcement> getAnnouncement(Long userId) {
        UserEntity userEntity = userRepository.findById(userId).get();
        List<AnnouncementEntity> announcementEntities = userEntity.getAnnouncementEntities();
        List<Announcement> announcements = announcementEntities
                .stream()
                .map(announcement -> new Announcement(announcement.getId(),
                        announcement.getTeacherId(),
                        announcement.getContent()))
                .collect(Collectors.toList());
        return announcements;
    }

}
