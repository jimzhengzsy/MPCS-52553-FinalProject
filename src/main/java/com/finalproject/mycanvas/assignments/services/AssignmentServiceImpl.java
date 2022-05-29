package com.finalproject.mycanvas.assignments.services;

import com.finalproject.mycanvas.assignments.model.Assignment;
import com.finalproject.mycanvas.users.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AssignmentServiceImpl implements AssignmentService{


    @Override
    public Assignment addAssignmentWithUser(Long userId, Long assignmentId) {
        return null;
    }

    @Override
    public Assignment addAssignmentWithUsers(List<User> users, Long assignmentId) {
        return null;
    }

    @Override
    public Assignment studentSaveAssignment(Long assignmentId) {
        return null;
    }

    @Override
    public Assignment teacherPostAssignment(Assignment assignment) {
        return null;
    }
}
