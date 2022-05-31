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
import org.springframework.http.HttpStatus;
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
                        user.getUserId(),
                        user.getFirstName(),
                        user.getLastName(),
                        user.getEmail(),
                        user.getRole(),
                        user.getStatus(),
                        user.getPassword(),
                        user.getLoginQuestion1(),
                        user.getLoginQuestion2(),
                        user.getLoginQuestion3(),
                        user.getLoginAnswer1(),
                        user.getLoginAnswer2(),
                        user.getLoginAnswer3()))
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
    public User getUserByEmail(String email) {
        UserEntity userEntity = userRepository.findByEmail(email);
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
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found user");
        }

        String correctPassword = userEntity.getPassword();
        if (correctPassword.equals(password)) {
            User user = new User();
            BeanUtils.copyProperties(userEntity,user);
            return ResponseEntity.ok(user);
        }

        return ResponseEntity.status(401).body("login failed");
    }

    @Override
    public ResponseEntity checkEmail(String email) {
        List<UserEntity> userEntities = userRepository.findAll();
        for (UserEntity userEntity: userEntities) {
            if (userEntity.getEmail().equals(email)) {
                User user = new User();
                BeanUtils.copyProperties(userEntity,user);
                return ResponseEntity.ok(user);
            }
        }

        return ResponseEntity.status(404).body("Email not found");
    }

    @Override
    public ResponseEntity checkLoginAnswers(String[] answers, Long id) {
        UserEntity userEntity = userRepository.findById(id).get();
        String answer1 = userEntity.getLoginAnswer1();
        String answer2 = userEntity.getLoginAnswer2();
        String answer3 = userEntity.getLoginAnswer3();
        String[] correctAnswers = new String[3];
        correctAnswers[0] = answer1;
        correctAnswers[1] = answer2;
        correctAnswers[2] = answer3;

        for (int i = 0; i < answers.length; i++) {
            if (!answers[i].equals(correctAnswers[i])) {
                return ResponseEntity.status(400).body("Answers not correct");
            }
        }

        return ResponseEntity.ok(200);
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
                        course.getTeacherId(),
                        course.getDescription(),
                        course.getCapacity()))
                .collect(Collectors.toList());

        return courses;

    }

    @Override
    public ResponseEntity addCourse(Long userId, Course course) {
        UserEntity userEntity = userRepository.findById(userId).get();
        List<CourseEntity> courseEntities = userEntity.getCourses();
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setId(course.getId());
        courseEntity.setName(course.getName());
        courseEntity.setTeacherId(course.getTeacherId());

        courseEntities.add(courseEntity);
        userRepository.save(userEntity);
        return ResponseEntity.ok(courseEntities);
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
                        assignment.getAssignmentName(),
                        assignment.getDue_date(),
                        assignment.getDescription()))
                .collect(Collectors.toList());
        return assignments;
    }

    @Override
    public ResponseEntity addAssignment(Long userId, Assignment assignment) {
        UserEntity userEntity = userRepository.findById(userId).get();
        List<AssignmentEntity> assignmentEntities = userEntity.getAssignments();
        AssignmentEntity assignmentEntity = new AssignmentEntity();
        assignmentEntity.setId(assignment.getId());
        assignmentEntity.setDescription(assignment.getDescription());
        assignmentEntity.setDue_date(assignment.getDue_date());
        assignmentEntity.setGrade(assignment.getGrade());
        assignmentEntity.setTeacherId(assignment.getTeacherId());

        assignmentEntities.add(assignmentEntity);

        userRepository.save(userEntity);

        return ResponseEntity.ok(assignmentEntities);
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

    @Override
    public ResponseEntity addAnnouncement(Long userId, Announcement announcement) {
        UserEntity userEntity = userRepository.findById(userId).get();
        List<AnnouncementEntity> announcementEntities = userEntity.getAnnouncementEntities();
        AnnouncementEntity announcementEntity = new AnnouncementEntity();
        announcementEntity.setId(announcement.getId());
        announcementEntity.setContent(announcement.getContent());
        announcementEntity.setTeacherId(announcement.getTeacherId());
        announcementEntities.add(announcementEntity);

        userRepository.save(userEntity);

        return ResponseEntity.ok(announcementEntities);
    }


}
