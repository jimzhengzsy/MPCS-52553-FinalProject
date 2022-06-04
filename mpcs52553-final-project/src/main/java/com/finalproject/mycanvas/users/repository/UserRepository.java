package com.finalproject.mycanvas.users.repository;

import com.finalproject.mycanvas.users.entity.NamePair;
import com.finalproject.mycanvas.users.entity.UserEntity;
import com.finalproject.mycanvas.courses.entity.CourseEntity;
import com.finalproject.mycanvas.assignments.entity.AssignmentEntity;
import com.finalproject.mycanvas.users.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    public UserEntity findByEmail(String Email);

    @Query("select u.firstName, u.lastName from UserEntity u where u.email = ?1")
    NamePair getUserNamePairByEmail(String email);


    @Query("select u from UserEntity u where u.firstName = ?1")
    List<UserEntity> getUserByFirstName(String firstName);

    @Query("select u from UserEntity u where u.lastName = ?1")
    List<UserEntity> getUserByLastName(String lastName);

    @Query("select u from UserEntity u where u.role = 'teacher' ")
    List<UserEntity> getTeachers();

    @Query(value = "select assignments.id, assignments.point, assignments.grade, assignments.due_date, assignments.assignment_name, courses.name, courses.description from users join enrollment on users.id = enrollment.user_id join course_assignment_map on enrollment.courses_id = course_assignment_map.course_id join assignments on course_assignment_map.assignment_id = assignments.id join courses on course_assignment_map.course_id = courses_id  where users.id = ?1 and enrollment.courses_id = ?2 ", nativeQuery = true)

    List<Object> getStudentAssignmentData(Long userId, Long courseId);
}
