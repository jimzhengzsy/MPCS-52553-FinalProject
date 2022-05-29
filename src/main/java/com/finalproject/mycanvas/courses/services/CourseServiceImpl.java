package com.finalproject.mycanvas.courses.services;

import com.finalproject.mycanvas.courses.entity.CourseEntity;
import com.finalproject.mycanvas.courses.model.Course;
import com.finalproject.mycanvas.courses.repository.CourseRepository;
import org.springframework.beans.BeanUtils;
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
                        course.getTeacherId()))
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
}
