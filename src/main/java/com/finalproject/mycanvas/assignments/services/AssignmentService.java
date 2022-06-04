package com.finalproject.mycanvas.assignments.services;


import com.finalproject.mycanvas.assignments.model.Assignment;
import com.finalproject.mycanvas.users.model.User;

import java.util.List;

public interface AssignmentService {
    // Assignment has a user
    Assignment getAssignmentById(Long id);
    Assignment addAssignmentWithUser(Long userId, Long assignmentId);
    Assignment addAssignmentWithUsers(List<User> users, Long assignmentId);

    Assignment getAssignmentWithUsers(Long assignmentId);
    Assignment studentSaveAssignment(Long assignmentId);
    Assignment teacherPostAssignment(Assignment assignment);

    List<User> getUsersWithAssignmentId(Long assignmentId);

    List<Assignment> getAllAssignments();

    Assignment updateAssignment(Long id, Assignment assignment);
    Assignment createAssignment(Assignment assignment);


}
