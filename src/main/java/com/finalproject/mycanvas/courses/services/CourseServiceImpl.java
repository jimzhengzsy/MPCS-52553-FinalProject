package com.finalproject.mycanvas.courses.services;

import com.finalproject.mycanvas.announcement.entity.AnnouncementEntity;
import com.finalproject.mycanvas.announcement.model.Announcement;
import com.finalproject.mycanvas.assignments.entity.AssignmentEntity;
import com.finalproject.mycanvas.assignments.model.Assignment;
import com.finalproject.mycanvas.courses.entity.CourseEntity;
import com.finalproject.mycanvas.courses.model.Course;
import com.finalproject.mycanvas.courses.repository.CourseRepository;
import com.finalproject.mycanvas.users.entity.UserEntity;
import com.finalproject.mycanvas.users.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService{
    private CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public ResponseEntity createCourse(Course course) throws Exception {
        if (course.getName() == null) {
            throw new Exception("Course information is not correct");
        }

        CourseEntity courseEntity = new CourseEntity();
        BeanUtils.copyProperties(course,courseEntity);
        courseRepository.save(courseEntity);

        return ResponseEntity.ok(course);
    }

    @Override
    public List<Course> getAllCourses() {
        List<CourseEntity> courseEntities = courseRepository.findAll();
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
    public Course getCourseById(Long id) {
        CourseEntity courseEntity = courseRepository.findById(id).get();
        Course course = new Course();
        BeanUtils.copyProperties(courseEntity,course);
        return course;
    }

    @Override
    public Course updateCourse(Long id, Course course) {
        return null;
    }

    @Override
    public ResponseEntity addUserToCourse(Long courseId, User user) {
        CourseEntity courseEntity = courseRepository.findById(courseId).get();
        List<UserEntity> userEntities = courseEntity.getUserEntities();

        UserEntity userEntity = new UserEntity();
        userEntity.setRole(user.getRole());
        userEntity.setEmail(user.getEmail());
        userEntity.setLastName(user.getLastName());
        userEntity.setFirstName(user.getFirstName());
        userEntity.setStatus(user.getStatus());
        userEntity.setPassword(user.getPassword());
        userEntity.setLoginQuestion1(user.getLoginQuestion1());
        userEntity.setLoginQuestion2(user.getLoginQuestion2());
        userEntity.setLoginQuestion3(user.getLoginQuestion3());

        userEntities.add(userEntity);

        courseRepository.save(courseEntity);

        return ResponseEntity.ok(userEntities);
    }

    @Override
    public ResponseEntity addAssignmentToCourse(Long courseId, Assignment assignment) {
        CourseEntity courseEntity = courseRepository.findById(courseId).get();
        List<AssignmentEntity> assignmentEntities = courseEntity.getAssigmentEntities();

        AssignmentEntity assignmentEntity = new AssignmentEntity();
        BeanUtils.copyProperties(assignment,assignmentEntity);
        assignmentEntities.add(assignmentEntity);
        courseRepository.save(courseEntity);

        return ResponseEntity.ok(assignmentEntities);
    }

    @Override
    public ResponseEntity addAnnouncementToCourse(Long courseId, Announcement announcement) {
        CourseEntity courseEntity = courseRepository.findById(courseId).get();
        List<AnnouncementEntity> announcementEntities = courseEntity.getAnnouncementEntities();

        AnnouncementEntity announcementEntity = new AnnouncementEntity();
        BeanUtils.copyProperties(announcement,announcementEntity);
        announcementEntities.add(announcementEntity);
        courseRepository.save(courseEntity);

        return ResponseEntity.status(201).body("Add anouncement to course");
    }

    @Override
    public List<User> getUsers(Long id) {
        CourseEntity courseEntity = courseRepository.findById(id).get();
        List<UserEntity> userEntities = courseEntity.getUserEntities();
        List<User> users = userEntities
                .stream()
                .map(user -> new User(user.getId(),
                        user.getFirstName(),
                        user.getLastName(),
                        user.getUserId(),
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
    public List<Object> getCourseAssignmentData(Long id) {
        return courseRepository.getCourseAssignmentData(id);
    }

    @Override
    public List<Announcement> getAnnouncementsByCourseId(Long courseId) {
        CourseEntity courseEntity = courseRepository.findById(courseId).get();
        List<AnnouncementEntity> announcementEntities = courseEntity.getAnnouncementEntities();
        List<Announcement> announcements = announcementEntities
                .stream()
                .map(announcement -> new Announcement(announcement.getId(),
                        announcement.getTeacherId(),
                        announcement.getCourseId(),
                        announcement.getContent()))
                .collect(Collectors.toList());
        return announcements;
    }

    @Override
    public List<Assignment> getAssignmentsByCourseId(Long courseId) {
        CourseEntity courseEntity = courseRepository.findById(courseId).get();
        List<AssignmentEntity> assignmentEntities = courseEntity.getAssigmentEntities();
        List<Assignment> assignments = assignmentEntities
                .stream()
                .map(assignment -> new Assignment(assignment.getId(),
                        assignment.getPoint(),
                        assignment.getGrade(),
                        assignment.getTeacherId(),
                        assignment.getCourseId(),
                        assignment.getAssignmentName(),
                        assignment.getDue_date(),
                        assignment.getDescription(),
                        assignment.getAnswer()))
                .collect(Collectors.toList());
        return assignments;
    }
}
