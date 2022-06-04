package com.finalproject.mycanvas.courses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.finalproject.mycanvas.courses.entity.CourseEntity;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, Long> {


    @Query(value = "select users.first_name, users.last_name, assignments.assignment_name, assignments.grade from users join enrollment on users.id = enrollment.user_id join course_assignment_map on enrollment.courses_id = course_assignment_map.course_id join assignments on course_assignment_map.assignment_id = assignments.id where enrollment.courses_id = ?1",nativeQuery = true)
    List<Object> getCourseAssignmentData(Long id);
}
